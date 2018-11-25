import toml
import urllib.request as request
from pprint import PrettyPrinter
import json
import pandas as pd
import numpy as np

config = toml.load('config.toml')


class Endpoints:
    trips_by_calendar = \
        'https://bristol.api.urbanthings.io/api/2.0/static/tripgroups/bycalendar?routeID=UK_TNDS_NOC_FBRI-X73-48-X73-_-y10-1'
    stop_list = \
        'https://bristol.api.urbanthings.io/api/2.0/static/trips?routeID=UK_TNDS_NOC_FBRI-75-38-75-_-y10-1'  # route ID for 75
    route_list = \
        'https://bristol.api.urbanthings.io/api/2.0/static/routes/info/Source?agencyID=UK_TNDS_NOC_FBRI'


headers = {
    'X-Api-Key': config['api_key'],
    'Accept': 'application/json'
}
req = request.Request(Endpoints.stop_list, None, headers)
processedTimetable = {}
outfile = open('output.json', 'w')

with request.urlopen(req) as response:
    timetable = json.loads(response.read())
    delays = []
    # pp.pprint(timetable)

    for trip in timetable['data']:
        for stop in trip['stopCalls']:
            stop_name = stop['transitStopLocalityName']

            if not stop_name in processedTimetable:
                processedTimetable[stop_name] = {
                    'scheduledArrivalTime': [],
                    'actualArrivalTime': [],
                    'delay': [],
                    'estimatedArrivalTime': []
                }

            processed_stop = processedTimetable[stop_name]

            # processedTimetable[stop_name]['scheduledArrivalTime'] = \
            #     datetime.strptime(
            #         stop['scheduledCall']['scheduledArrivalTime'],
            #         '%Y-%m-%dT%H:%M:%S+00:00'
            #     ).to

            scheduledArrival = pd.to_datetime(stop['scheduledCall']['scheduledArrivalTime'], infer_datetime_format=True)
            processed_stop['scheduledArrivalTime'].append(scheduledArrival.strftime('%H:%M:%S'))

            delay = np.int(min(np.abs(np.random.normal(0, 15)), 15))

            processed_stop['actualArrivalTime'].append(
                (
                        scheduledArrival + pd.Timedelta('{} minutes'.format(delay))
                ). \
                    strftime('%H:%M:%S')
            )

            processed_stop['delay'].append(delay)
            processed_stop['averageDelay'] = np.average(processedTimetable[stop_name]['delay'])

            delays.append(delay)

    averageDelay = np.average(delays)

    for stop in processedTimetable:
        stop_dict = processedTimetable[stop]
        stop_dict['estimatedArrivalTime'] = \
            pd.to_datetime(stop_dict['scheduledArrivalTime']) + \
            pd.Timedelta('{} minutes'.format(stop_dict['averageDelay']))
        stop_dict['estimatedArrivalTime'] = stop_dict['estimatedArrivalTime'].strftime('%H:%M:%S').tolist()

        # processedTimetable[stop]['estimatedArrivalTime'].extend(stop_dict['estimatedArrivalTime'].strftime('%H:%M:%S').values)
    # processedTimetable['averageDelay'] = averageDelay
    json.dump(processedTimetable, outfile, indent=4)

    outfile.close()
