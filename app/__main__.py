from flask import Flask, render_template, url_for
from flask import request
from flask_restful import Resource, Api
from flask_helper import ReverseProxied
from bristolapi import BristolApi
import json
import toml

config = toml.load('config.toml')
bapi = BristolApi(config)

app = Flask(__name__, static_url_path='/static')
app.wsgi_app = ReverseProxied(app.wsgi_app)

api = Api(app)

@app.route('/')
def root():
    print (url_for('static', filename='app.js'))
    return render_template('index.html')

@app.route('/routes/<stopID>')
def routes(stopID):
    stopID = BristolApi.Stops.__dict__.get(stopID, stopID)
    return json.dumps(bapi.get_trips_by_stopID(stopID))

@app.route('/report')
def report():
    pass

app.run(debug=True)
