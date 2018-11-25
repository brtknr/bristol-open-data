import * as constants from './constants.js'

function floatingPointEquals(a, b, precision = 0.0001) {
    return Math.abs(a - b) < precision;
}

export class Coordinates {
    constructor(lat = constants.bristolCoordinates.lat, long = constants.bristolCoordinates.long) {
        this.lat = lat;
        this.long = long;
    }

    withCoordinatesDelta(latDelta, longDelta = 0) {
        return new Coordinates(this.lat + latDelta, this.long + longDelta);
    }

    equals(coordinates, precision = 0.0001) {
        return floatingPointEquals(this.lat, coordinates.lat, precision)
            && floatingPointEquals(this.long, coordinates.long, precision);
    }

    toString() {
        return `lat: ${this.lat}, long; ${this.long}`;
    }
}

export class BusMarker {
    constructor(map, coordinates = new Coordinates()) {
        this.currentCoordinates = coordinates;

        let busIcon = this._getBusIcon();

        this._marker = L.marker([coordinates.lat, coordinates.long], { icon: busIcon }).addTo(map);

        return this;
    }

    moveMarker(lat, long) {
        this.currentCoordinates = new Coordinates(lat, long);
        this._updatePosition();
    }

    moveMarkerByDelta(latDelta, longDelta = 0) {
        this.currentCoordinates = this.currentCoordinates.withCoordinatesDelta(latDelta, longDelta);
        this._updatePosition();
    }

    async followPath(coordinatesArray, speed = 0.00005) {
        for (let destinationCoordinates of coordinatesArray) {
            await new Promise((resolve, reject) => {
                if (constants.debug) console.log(`current destination: ${destinationCoordinates}`);

                let latDistance = Math.abs(this.currentCoordinates.lat - destinationCoordinates.lat);
                let longDistance = Math.abs(this.currentCoordinates.long - destinationCoordinates.long);
                let distance = Math.sqrt(Math.pow(latDistance, 2) + Math.pow(longDistance, 2));
                let time = distance / speed;

                let latSpeed = latDistance / time;
                let longSpeed = longDistance / time;

                let interval = setInterval(() => {
                    if (constants.debug) console.log(`current position: ${this.currentCoordinates.toString()}`);

                    if (!floatingPointEquals(destinationCoordinates.lat, this.currentCoordinates.lat)) {
                        let latDirection = destinationCoordinates.lat > this.currentCoordinates.lat ? 1 : -1;
                        this.moveMarkerByDelta(latDirection * latSpeed);
                    }

                    if (!floatingPointEquals(destinationCoordinates.long, this.currentCoordinates.long)) {
                        let longDirection = destinationCoordinates.long > this.currentCoordinates.long ? 1 : -1;
                        this.moveMarkerByDelta(0, longDirection * longSpeed);
                    }

                    if (this.currentCoordinates.equals(destinationCoordinates)) {
                        clearInterval(interval);

                        // since floating point equality comparision might result in the bus being in a location
                        // a tad different than the destinationCoordinates let's move it there to be sure
                        this.moveMarker(destinationCoordinates.lat, destinationCoordinates.long);

                        resolve();
                    }
                }, 1000);
            });
        }
    }

    _updatePosition() {
        let newLatLng = new L.LatLng(this.currentCoordinates.lat, this.currentCoordinates.long);
        this._marker.setLatLng(newLatLng);
    }

    // https://leafletjs.com/examples/custom-icons/
    _getBusIcon() {
        let busIcon = L.Icon.extend({
            options: {
                iconSize: [30, 30]
            }
        })

        return new busIcon({ iconUrl: 'assets/icon-double-decker-bus.png' });
    }
}