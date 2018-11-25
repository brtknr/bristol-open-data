let debug = true;

let bristolCoordinates = {
    lat: 51.454514,
    long: -2.587910
}

let mymap = L.map('mapid').setView([bristolCoordinates.lat, bristolCoordinates.long], 30);

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWVsbWV4IiwiYSI6ImNqb3c3eTljYTFwOGIzcWxrcmtidGsybjMifQ.uT34uyxAR71bitfzLBot7w', {
    maxZoom: 18,
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
        '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
        'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    id: 'mapbox.streets'
}).addTo(mymap);


class MarkerPosition {
    constructor(lat = bristolCoordinates.lat, long = bristolCoordinates.long) {
        this.lat = lat;
        this.long = long;
    }

    withCoordinatesDelta(newLat, newLong = 0) {
        return new MarkerPosition(this.lat + newLat, this.long + newLong);
    }

    toString() {
        return `lat: ${this.lat}, long; ${this.long}`;
    }
}

class Marker {
    constructor(map, markerPosition = new MarkerPosition()) {
        let busIcon = this._getBusIcon();

        return L.marker([markerPosition.lat, markerPosition.long], { icon: busIcon }).addTo(mymap);
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

let marker = new Marker();

function moveMarker(lat, long) {
    var newLatLng = new L.LatLng(lat, long);
    marker.setLatLng(newLatLng);
}

let currentMarkerPosition = new MarkerPosition();

setInterval(() => {
    if (debug)
        console.log(`new pos: ${currentMarkerPosition.toString()}`);
    currentMarkerPosition = currentMarkerPosition.withCoordinatesDelta(0.000001);
    moveMarker(currentMarkerPosition.lat, currentMarkerPosition.long);
}, 100);