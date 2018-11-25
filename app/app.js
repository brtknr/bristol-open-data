import * as constants from './constants.js'
import * as busMarkerModule from './bus-marker-module.js';

let map = L.map('mapid').setView([constants.bristolCoordinates.lat + 0.002, constants.bristolCoordinates.long], 16);

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWVsbWV4IiwiYSI6ImNqb3c3eTljYTFwOGIzcWxrcmtidGsybjMifQ.uT34uyxAR71bitfzLBot7w', {
    maxZoom: 18,
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
        '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
        'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    id: 'mapbox.streets'
}).addTo(map);

let baldwinStreetRoute1 = [
    new busMarkerModule.Coordinates(51.45382, -2.59174),
    new busMarkerModule.Coordinates(51.45341, -2.5946),
    new busMarkerModule.Coordinates(51.45404, -2.59529),
    new busMarkerModule.Coordinates(51.45493, -2.59302),
    new busMarkerModule.Coordinates(51.45382, -2.59174)
]

let broadWeirRoute1 = [
    new busMarkerModule.Coordinates(51.459, -2.5955),
    new busMarkerModule.Coordinates(51.4578, -2.5922),
    new busMarkerModule.Coordinates(51.4557, -2.5906),
    new busMarkerModule.Coordinates(51.457, -2.5859),
]

let marlboroughStreetRoute1 = [
    new busMarkerModule.Coordinates(51.45958, -2.59141),
    new busMarkerModule.Coordinates(51.45979, -2.59432),
    new busMarkerModule.Coordinates(51.4569, -2.5976),
    new busMarkerModule.Coordinates(51.4598, -2.6012),
]

let routes = [baldwinStreetRoute1, broadWeirRoute1, marlboroughStreetRoute1];

for (let route of routes) {
    let busMarker = new busMarkerModule.BusMarker(map, route[0]);
    busMarker.followPath(route.slice(1));
}
