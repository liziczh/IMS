package com.liziczh.ims.service;

import java.util.List;

public interface ILedgerService {
    public List<String> createPie(String recordType, String startTime, String endTime);
}