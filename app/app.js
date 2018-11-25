import * as constants from './constants.js'
import * as busMarkerModule from './bus-marker-module.js';

let debug = true;

let map = L.map('mapid').setView([constants.bristolCoordinates.lat, constants.bristolCoordinates.long], 30);

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWVsbWV4IiwiYSI6ImNqb3c3eTljYTFwOGIzcWxrcmtidGsybjMifQ.uT34uyxAR71bitfzLBot7w', {
    maxZoom: 18,
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
        '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
        'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    id: 'mapbox.streets'
}).addTo(map);

let marker = new busMarkerModule.BusMarker(map);

setInterval(() => {
    if (debug)
        console.log(`new pos: ${marker.coordinates.toString()}`);
    marker.moveMarkerByDelta(0.000001);
}, 100);