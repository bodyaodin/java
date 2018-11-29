package com.webservice.managers;

import com.webservice.config.Connection;
import org.oorsprong.websamples.TContinent;
import org.oorsprong.websamples.TCountryInfo;
import org.oorsprong.websamples.TLanguage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Read country info from WSDL and write it to CSV file
 */
public class Manager {

    Connection connection;

    public Manager(Connection connection) {
        this.connection = connection;
    }

    public void saveAllCountriesInfo() {
        try {
            PrintWriter pw = new PrintWriter(new File("CountryInfo.csv"));

            StringBuilder sb = new StringBuilder();
            sb.append("sep =,");
            sb.append("\n");

            sb.append("IsoCode");
            sb.append(",");
            sb.append("CountryName");
            sb.append(",");
            sb.append("Capital");
            sb.append(",");
            sb.append("PhoneCode");
            sb.append(",");
            sb.append("ContinentCode");
            sb.append(",");
            sb.append("CurrencyISOCode");
            sb.append(",");
            sb.append("Languages");
            sb.append(",");
            sb.append("CountryFlag");
            sb.append("\n\n");

            saveContinentsInfo(sb);

            pw.print(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveContinentsInfo(StringBuilder sb) {
        for (TContinent continent : connection.getInfo().listOfContinentsByName().getTContinent()) {
            sb.append(continent.getSCode());
            sb.append(",");
            sb.append(continent.getSName());
            sb.append("\n\n");

            saveCountryInfo(sb, continent.getSCode());

            sb.append("\n");

        }
    }

    private void saveCountryInfo(StringBuilder sb, String code) {
        for (TCountryInfo country : connection.getInfo().fullCountryInfoAllCountries().getTCountryInfo()) {
            if (code.equals(country.getSContinentCode())){
                sb.append(country.getSISOCode());
                sb.append(",");
                if (country.getSName().contains(",")) {
                    sb.append(country.getSName().replace(",", " - "));
                } else {
                    sb.append(country.getSName());
                }
                sb.append(",");
                if (country.getSCapitalCity().contains(",")) {
                    sb.append(country.getSCapitalCity().replace(",", ";"));
                } else {
                    sb.append(country.getSCapitalCity());
                }
                sb.append(",");
                sb.append(country.getSPhoneCode());
                sb.append(",");
                sb.append(country.getSContinentCode());
                sb.append(",");
                sb.append(country.getSCurrencyISOCode());
                sb.append(",");
                for (TLanguage language : country.getLanguages().getTLanguage()) {
                    if (language.getSName().contains(",")) {
                        sb.append(language.getSName().replace(",", " - "));
                    } else {
                        sb.append(language.getSName());
                    }
                    sb.append(": ");
                    sb.append(language.getSISOCode());
                    sb.append("; ");
                }
                sb.append(",");
                if (country.getSCountryFlag().contains(",")) {
                    sb.append(country.getSCountryFlag().replace(",", ""));
                } else {
                    sb.append(country.getSCountryFlag());
                }
                sb.append("\n");

            }
        }
    }
}
