import * as constants from './constants.js'

class Coordinates {
    constructor(lat = constants.bristolCoordinates.lat, long = constants.bristolCoordinates.long) {
        this.lat = lat;
        this.long = long;
    }

    withCoordinatesDelta(newLat, newLong = 0) {
        return new Coordinates(this.lat + newLat, this.long + newLong);
    }

    toString() {
        return `lat: ${this.lat}, long; ${this.long}`;
    }
}

export class BusMarker {
    constructor(map, coordinates = new Coordinates()) {
        this.coordinates = coordinates;

        let busIcon = this._getBusIcon();

        this._marker = L.marker([coordinates.lat, coordinates.long], { icon: busIcon }).addTo(map);

        return this;
    }

    moveMarker(lat, long) {
        this.coordinates = new Coordinates(lat, long);
        this._updatePosition();
    }

    moveMarkerByDelta(latDelta, longDelta = 0) {
        this.coordinates = this.coordinates.withCoordinatesDelta(latDelta, longDelta);
        this._updatePosition();
    }

    _updatePosition() {
        let newLatLng = new L.LatLng(this.coordinates.lat, this.coordinates.long);
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