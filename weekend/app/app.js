import * as constants from './constants.js'
import * as busMarkerModule from './bus-marker-module.js';
import * as sidebar from './sidebar.js';

let map = L.map('mapid').setView([constants.bristolCoordinates.lat + 0.002, constants.bristolCoordinates.long - 0.003], 15);

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

let selectedBusRouteCribsCauseWayToNineTreeHill = [
    new busMarkerModule.Coordinates(51.452316, -2.596988),
    new busMarkerModule.Coordinates(51.455962, -2.596103),
    new busMarkerModule.Coordinates(51.458903, -2.591598),
    new busMarkerModule.Coordinates(51.460316, -2.591121),
    new busMarkerModule.Coordinates(51.464804, -2.590090)
]

let collegeGreenToCliftonDown = [
    new busMarkerModule.Coordinates(51.452926, -2.600861),
    new busMarkerModule.Coordinates(51.455961, -2.605528),
    new busMarkerModule.Coordinates(51.456483, -2.608060),
    new busMarkerModule.Coordinates(51.460982, -2.608671),
    new busMarkerModule.Coordinates(51.464224, -2.609669)
]

// main bus
let nineTreeHillToTriangleWest = [
    new busMarkerModule.Coordinates(51.464804, -2.590090),
    new busMarkerModule.Coordinates(51.460982, -2.608671),
    new busMarkerModule.Coordinates(51.458903, -2.591598)
]

let routes = [baldwinStreetRoute1,
    broadWeirRoute1,
    marlboroughStreetRoute1,
    collegeGreenToCliftonDown,
    nineTreeHillToTriangleWest,
    selectedBusRouteCribsCauseWayToNineTreeHill
];

let sidebarDataList = [
    new sidebar.SidebarData(
        1, 2, 3, 4, 5
    ),
    new sidebar.SidebarData(
        3, 3, 3, 3, 3
    ),
    new sidebar.SidebarData(
        4, 5, 5, 5, 5
    ),
    new sidebar.SidebarData(
        5, 5, 5, 5, 5
    ),
    new sidebar.SidebarData(
        6, 5, 5, 5, 5
    ),
    new sidebar.SidebarData(
        7, 5, 5, 5, 5
    ),
    new sidebar.SidebarData(
        8, 5, 5, 5, 5
    )
];

/* sidebar */

let sidebarUpdater = new sidebar.SidebarUpdater();

let currentStopId = 0;
let onSelectedBusStopReachedCallback = () => {
    sidebarUpdater.updateFields(document, sidebarDataList[currentStopId++]);
}

/* /sidebar */

for (var i = 0; i < routes.length; i++) {
    let route = routes[i];
    var selected = false;

    if (i == 5) {
        selected = true;
    }

    let busMarker = new busMarkerModule.BusMarker(map, route[0], selected);

    for (let stop of route) {
        new busMarkerModule.BusStop(map, stop, selected);
    }

    let isSelectedBusRoute = route == selectedBusRouteCribsCauseWayToNineTreeHill;
    let onBusStopReachedCallback = isSelectedBusRoute
        ? onSelectedBusStopReachedCallback
        : () => {};
    busMarker.followPath(route.slice(1), onBusStopReachedCallback);
}

var stops = [];

for (let route of selectedBusRouteCribsCauseWayToNineTreeHill) {
    stops.push(new L.LatLng(route.lat, route.long))
}

var polylineOptions = {
    color: 'blue',
    weight: 6,
    opacity: 0.9
};

var polyline = new L.Polyline(stops, polylineOptions);
map.addLayer(polyline);
