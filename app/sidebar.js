export class SidebarData {
    constructor(actualArrivalTime, averageDelay, delay, estimatedArrivalTime, scheduledArrivalTime) {
        this.actualArrivalTime = actualArrivalTime;
        this.averageDelay = averageDelay;
        this.delay = delay;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.scheduledArrivalTime = scheduledArrivalTime;
    };
}

export class SidebarUpdater {
    updateFields(document, sidebarData) {
        this._updateField(document, 'actual-arrival-time', sidebarData.actualArrivalTime);
        this._updateField(document, 'average-delay', sidebarData.averageDelay);
        this._updateField(document, 'estimated-arrival-time', sidebarData.estimatedArrivalTime);
        this._updateField(document, 'scheduled-arrival-time', sidebarData.scheduledArrivalTime);
    }

    _updateField(document, fieldName, value) {
        let field = document.getElementById(fieldName);
        let fieldValue = field.getElementsByClassName('value')[0];
        fieldValue.innerHTML = value;
    }
}