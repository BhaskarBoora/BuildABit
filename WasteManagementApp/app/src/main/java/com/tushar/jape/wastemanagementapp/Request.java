package com.tushar.jape.wastemanagementapp;

class Request {

    String getDateOfRequest() {
        return dateOfRequest;
    }

    String getPictureLink() {
        return pictureLink;
    }

    String getType() {
        return type;
    }

    int getHourOfRequest() {
        return hourOfRequest;
    }

    int getAmount() {
        return amount;
    }

    int getStatus() {
        return status;
    }

    private String dateOfRequest, pictureLink, type;
    private int hourOfRequest, amount, status;

    Request(String date, String picLink, String typ, int hr, int amt, int st){
        dateOfRequest = date;
        pictureLink = picLink;
        type = typ;
        hourOfRequest = hr;
        amount = amt;
        status = st;
    }
}
