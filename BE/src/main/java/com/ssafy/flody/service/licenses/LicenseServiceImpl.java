package com.ssafy.flody.service.licenses;

import com.ssafy.flody.domain.licenses.Licenses;
import com.ssafy.flody.domain.licenses.LicensesRepository;
import com.ssafy.flody.domain.licenses.departments.Departments;
import com.ssafy.flody.domain.licenses.departments.DepartmentsRepository;
import com.ssafy.flody.domain.licenses.fields.Fields;
import com.ssafy.flody.domain.licenses.fields.FieldsRepository;
import com.ssafy.flody.domain.licenses.mfields.MFields;
import com.ssafy.flody.domain.licenses.mfields.MFieldsRepository;
import com.ssafy.flody.domain.licenses.serieses.Serieses;
import com.ssafy.flody.domain.licenses.serieses.SeriesesRepository;
import com.ssafy.flody.domain.licenses.sjobs.SJobs;
import com.ssafy.flody.domain.licenses.sjobs.SJobsRepository;
import com.ssafy.flody.domain.licenses.tjobs.TJobs;
import com.ssafy.flody.domain.licenses.tjobs.TJobsRepository;
import com.ssafy.flody.dto.response.licenses.LicensesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import org.json.JSONObject;
import org.json.XML;

@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final LicensesRepository licenseRepository;
    private final FieldsRepository fieldRepository;
    private final MFieldsRepository mFieldRepository;
    private final SeriesesRepository seriesRepository;
    private final DepartmentsRepository departmentRepository;
    private final TJobsRepository tJobRepository;
    private final SJobsRepository sJobRepository;

    private final String SERVICE_KEY = "=mlct4Des%2Fz33bFE55AaHS7icAy085mHrSR1l5QCSwkWfFVWn%2FCxTLJXCeqSGN%2FiE%2FKA1Hp2XgKal%2FGJl7k8z4w%3D%3D";

    public String getLicense() throws Exception {
//        storeLicense(getData("http://openapi.q-net.or.kr/api/service/rest/InquiryListNationalQualifcationSVC/getList?"));
//        storeTJobs(getData("http://openapi.q-net.or.kr/api/service/rest/InquiryUdeptObligSVC/getList?pageNo=1&numOfRows=11539&"));
//        storeSJobs(getData("http://openapi.q-net.or.kr/api/service/rest/InquirySeriesUdeptSVC/getList?"));
        return "SUCCESS";
    }

    public String getData(String dataUrl) throws Exception {
        StringBuilder urlBuilder = new StringBuilder(dataUrl); /*URL*/
        urlBuilder.append(URLEncoder.encode("serviceKey","UTF-8") + SERVICE_KEY); /*Service Key*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }

    public void storeLicense(String xml) {
        xml = xml.split("items")[1];
        xml = xml.substring(1, xml.length() - 2);

        List<String> itemList = new ArrayList<>();
        String[] items = xml.split("item");
        for (int i = 1; i < items.length; i += 2) {
            itemList.add(items[i]);
        }

        for (String string : itemList) {
            String jmcd = splitter(string, "jmcd", 1);
            String jmfldnm = splitter(string, "jmfldnm", 1);
            String mdobligfldcd = splitter(string, "mdobligfldcd", 1);
            String mdobligfldnm = splitter(string, "mdobligfldnm", 1);
            String obligfldcd = splitter(string, "obligfldcd", 3);
            String obligfldnm = splitter(string, "obligfldnm", 3);
            String qualgbcd = splitter(string, "qualgbcd", 1);
            String qualgbnm = splitter(string, "qualgbnm", 1);
            String seriescd = splitter(string, "seriescd", 1);
            String seriesnm = splitter(string, "seriesnm", 1);

            try {
                findMField(mdobligfldnm);
            } catch (Exception e) {
                mFieldRepository.save(MFields.builder()
                                .mobligfldcd(mdobligfldcd)
                                .mobligfldnm(mdobligfldnm)
                        .build());
            }
            try {
                findField(obligfldnm);
            } catch (Exception e) {
                fieldRepository.save(Fields.builder()
                        .obligfldcd(obligfldcd)
                        .obligfldnm(obligfldnm)
                        .build());
            }
            try {
                findSeries(seriesnm);
            } catch (Exception e) {
                seriesRepository.save(Serieses.builder()
                        .seriescd(seriescd)
                        .seriesnm(seriesnm)
                        .build());
            }

            licenseRepository.save(Licenses.builder()
                            .field(findField(obligfldnm))
                            .mfield(findMField(mdobligfldnm))
                            .series(findSeries(seriesnm))
                            .jmcd(jmcd)
                            .jmfldnm(jmfldnm)
                            .qualgbcd(qualgbcd)
                            .qualgbnm(qualgbnm)
                    .build());
        }
    }

    public void storeTJobs(String xml) {
        xml = xml.split("items")[1];
        xml = xml.substring(1, xml.length() - 2);

        List<String> itemList = new ArrayList<>();
        String[] items = xml.split("item");
        for (int i = 1; i < items.length; i += 2) {
            itemList.add(items[i]);
        }

        for (String string : itemList) {
            String udeptcd = splitter(string, "udeptcd", 1);
            String udeptmdobligcd = splitter(string, "udeptmdobligcd", 1);
            String udeptmdoblignm = splitter(string, "udeptmdoblignm", 1);
            String udeptnm = splitter(string, "udeptnm", 1);
            String udeptobligcd = splitter(string, "udeptobligcd", 1);
            String udeptoblignm = splitter(string, "udeptoblignm", 1);

            try {
                findMField(udeptmdoblignm);
            } catch (Exception e) {
                mFieldRepository.save(MFields.builder()
                        .mobligfldcd(udeptmdobligcd)
                        .mobligfldnm(udeptmdoblignm)
                        .build());
            }
            try {
                findField(udeptoblignm);
            } catch (Exception e) {
                fieldRepository.save(Fields.builder()
                        .obligfldcd(udeptobligcd)
                        .obligfldnm(udeptoblignm)
                        .build());
            }
            try {
                findDepartment(udeptnm);
            } catch (Exception e) {
                departmentRepository.save(Departments.builder()
                        .udeptcd(udeptcd)
                        .udeptnm(udeptnm)
                        .build());
            }

            tJobRepository.save(TJobs.builder()
                            .field(findField(udeptoblignm))
                            .mField(findMField(udeptmdoblignm))
                            .department(findDepartment(udeptnm))
                    .build()
            );
        }
    }

    public void storeSJobs(String xml) {
        xml = xml.split("items")[1];
        xml = xml.substring(1, xml.length() - 2);

        List<String> itemList = new ArrayList<>();
        String[] items = xml.split("item");
        for (int i = 1; i < items.length; i += 2) {
            itemList.add(items[i]);
        }

        for (String string : itemList) {
            String seriescd = splitter(string, "seriescd", 1);
            String seriesnm = splitter(string, "seriesnm", 1);
            String udeptcd = splitter(string, "udeptcd", 1);
            String udeptnm = splitter(string, "udeptnm", 1);

            try {
                findSeries(seriesnm);
            } catch (Exception e) {
                seriesRepository.save(Serieses.builder()
                        .seriescd(seriescd)
                        .seriesnm(seriesnm)
                        .build());
            }
            try {
                findDepartment(udeptnm);
            } catch (Exception e) {
                departmentRepository.save(Departments.builder()
                        .udeptcd(udeptcd)
                        .udeptnm(udeptnm)
                        .build());
            }

            sJobRepository.save(SJobs.builder()
                            .department(findDepartment(udeptnm))
                            .series(findSeries(seriesnm))
                    .build());
        }
    }

    public List<LicensesResponseDto> findLicenses(String fldnm, String mfldnm, String category, String keyword, Pageable pageable) {

        System.out.println(fldnm);
        System.out.println(mfldnm);
        System.out.println(category);
        System.out.println(keyword);

        Fields field;
        MFields mField;
        List<Licenses> entityList = new ArrayList<>();
        List<LicensesResponseDto> list = new ArrayList<>();
        if (category.equals("학과명")) {
            List<Departments> departmentList = departmentRepository.findByUdeptnmContainingIgnoreCase(keyword);
            for (Departments department : departmentList) {
                List<TJobs> tJobsList = tJobRepository.findAllByDepartment(department);
                for (TJobs tJobs : tJobsList) {
                    entityList.addAll(licenseRepository.findAllByMfield(tJobs.getMField()));
                }
                List<SJobs> sJobsList = sJobRepository.findAllByDepartment(department);
                for (SJobs sJobs : sJobsList) {
                    entityList.addAll(licenseRepository.findAllBySeries(sJobs.getSeries()));
                }
            }
            Set<Licenses> tempSet = new HashSet<>(entityList);
            entityList = new ArrayList<>(tempSet);
            for (Licenses license : entityList) {
                list.add(new LicensesResponseDto(license));
            }
        } else {
            if (!fldnm.equals("")&&!mfldnm.equals("")) {
                entityList = licenseRepository.findAllByFieldAndMfieldAndJmfldnmContainingIgnoreCase(findField(fldnm), findMField(mfldnm), keyword);
            } else if (!fldnm.equals("")){
                entityList = licenseRepository.findAllByFieldAndJmfldnmContainingIgnoreCase(findField(fldnm), keyword);
            } else {
                entityList = licenseRepository.findAllByJmfldnmContainingIgnoreCase(keyword);
            }
            for (Licenses license : entityList) {
                list.add(new LicensesResponseDto(license));
            }
        }
        Comparator<LicensesResponseDto> comparator = new Comparator<LicensesResponseDto>() {
            @Override
            public int compare(LicensesResponseDto o1, LicensesResponseDto o2) {
                return (int) (o2.getLisNo() - o1.getLisNo());
            }
        };

        Collections.sort(list, comparator);
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();
        int from = page * size;
        int upto = Math.min(list.size(), (page + 1) * size);
        return list.subList(from, upto);
    }

    public List<String> findAllFields() {
        List<Fields> entityList = fieldRepository.findAll();
        List<String> list = new ArrayList<>();
        for (Fields field : entityList) {
            list.add(field.getObligfldnm());
        }
        return list;
    }
    public List<String> findAllMFields(String fldnm) {
        List<TJobs> tJobsList = tJobRepository.findAllByField(findField(fldnm));
        List<MFields> mFieldsList = new ArrayList<>();
        for (TJobs tJobs : tJobsList) {
            mFieldsList.add(tJobs.getMField());
        }
        Set<MFields> tempSet = new HashSet<>(mFieldsList);
        List<MFields> entityList = new ArrayList<>(tempSet);
        List<String> list = new ArrayList<>();
        for (MFields mfield : entityList) {
            list.add(mfield.getMobligfldnm());
        }
        return list;
    }

    public String splitter(String string, String key, int order) {
        string = string.split(key)[order];
        return string.substring(1, string.length() - 2);
    }

    public Fields findField(String obligfldnm) {
        return fieldRepository.findByObligfldnm(obligfldnm)
                .orElseThrow(() -> new IllegalArgumentException("Field Not Found"));
    }

    public MFields findMField(String mobligfldnm) {
        return mFieldRepository.findByMobligfldnm(mobligfldnm)
                .orElseThrow(() -> new IllegalArgumentException("MField Not Found"));
    }

    public Serieses findSeries(String seriesnm) {
        return seriesRepository.findBySeriesnm(seriesnm)
                .orElseThrow(() -> new IllegalArgumentException("Field Not Found"));
    }

    public Departments findDepartment(String udeptnm) {
        return departmentRepository.findByUdeptnm(udeptnm)
                .orElseThrow(() -> new IllegalArgumentException("Department Not Found"));
    }
}
