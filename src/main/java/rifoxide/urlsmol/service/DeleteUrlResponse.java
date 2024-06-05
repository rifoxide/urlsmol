package rifoxide.urlsmol.service;

import rifoxide.urlsmol.response.ResponseStatus;

public class DeleteUrlResponse {
    ResponseStatus status_msg;

    public DeleteUrlResponse(ResponseStatus status_msg) {
        this.status_msg = status_msg;
    }

    public ResponseStatus getStatus_msg() {
        return status_msg;
    }

    public void setStatus_msg(ResponseStatus status_msg) {
        this.status_msg = status_msg;
    }
}
