from bristolapi import BristolApi
import toml
import json
import unittest
import sys

class Test(unittest.TestCase):
    def setUp(self):
        config = toml.load('config.toml')
        self.api = BristolApi(config)
        self.routeID = BristolApi.Routes.n75
        self.stopID = BristolApi.Stops.cabot
        self.verbose = False

    def test_req_trips(self):
        result = self.api.req_trips(self.routeID)
        if self.verbose:
            print(json.dumps(result, indent=4))

    def test_req_routes_CallingAtStop(self):
        result = self.api.req_routes_CallingAtStop(self.stopID)
        if self.verbose: 
            print(json.dumps(result, indent=4))

    def test_get_trips_by_stopID(self):
        result = self.api.get_trips_by_stopID(self.stopID)
        if self.verbose: 
            print(json.dumps(result, indent=4))

if __name__ == '__main__':
    unittest.main()
