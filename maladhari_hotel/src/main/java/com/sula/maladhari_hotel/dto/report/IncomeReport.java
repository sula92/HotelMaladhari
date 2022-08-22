package com.sula.maladhari_hotel.dto.report;

import java.util.Date;

public interface IncomeReport {

    Date getStartingDate();

    Date getEndingDate();

    double getIncomeFromRooms();

    double getIncomeFromResidentialSuites();

    double getTotalIncome();

}
