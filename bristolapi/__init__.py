from urllib import request
import json
import time

class BristolApi(object):

    class Routes(object):
        m2 = 'UK_TNDS_NOC_FBRI-M2-38-M2-_-y10-1'
        n75 = 'UK_TNDS_NOC_FBRI-75-38-75-_-y10-1'

    class Agency(object):
        first = 'UK_TNDS_NOC_FBRI'

    class Stops(object):
        center = '0100BRZ00692'
        cabot = '010000036'
    
    class Endpoints(object):
        prefix = 'https://bristol.api.urbanthings.io/api/2.0'
        static = f'{prefix}/static'
        rti = f'{prefix}/rti'
        trips = f'{static}/trips?routeID={{}}&includeStopCoordinates={{}}'
        tripgroups_by_calendar = f'{static}/tripgroups/bycalendar?routeID={{}}'
        routes_Source = f'{static}/routes/info/Source?agencyID={{}}'
        routes_CallingAtStop = f'{static}/routes/info/CallingAtStop?stopID={{}}'

    def __init__(self, config):
        self.headers = {
            'X-Api-Key': config['api_key'],
            'Accept': 'application/json'
        }

    def request(self, URL):
        req = request.Request(URL, None, self.headers)
        with request.urlopen(req) as response:
            data = json.loads(response.read())
        return data

    def get_trips_by_stopID(self, stopID, limit=3):
        result = self.req_routes_CallingAtStop(stopID)
        if limit:
            result = result[:limit]
        return [t for route in result for t in self.req_trips(route['routeID'])]

    def req_routes_CallingAtStop(self, stopID):
        URL = self.Endpoints.routes_CallingAtStop.format(stopID)
        result = self.request(URL)
        return result.get('data')

    def req_trips(self, routeID, includeStopCoordinates=True):
        URL = self.Endpoints.trips.format(routeID, includeStopCoordinates)
        result = self.request(URL)
        return [trip.get('stopCalls') for trip in result.get('data')]
