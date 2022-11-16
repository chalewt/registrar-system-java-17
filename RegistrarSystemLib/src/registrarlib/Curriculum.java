/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrarlib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ChalewT
 */
public class Curriculum {

    int code;
    String field;
    String nomc;
    String nomcAm;
    String program;
    String admission;
    int year;
    int semester;
    int minCredit;
    String version;
    
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getNomc() {
        return nomc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public String getNomcAm() {
        return nomcAm;
    }

    public void setNomcAm(String nomcAm) {
        this.nomcAm = nomcAm;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getMinCredit() {
        return minCredit;
    }

    public void setMinCredit(int minCredit) {
        this.minCredit = minCredit;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
//</editor-fold>
    //
    public boolean registerCurriculum(Curriculum curr, int deptCode) throws Exception {
        String sqlInsertCurr = "Insert into CURRICULUM(FIELD_OF_STUDY, EN_NOMENCLATURE, AM_NOMENCLATURE, PROGRAM, ADMISSION_CLASS, STAY_YEAR, STAY_SEMESTER, MIN_CREDIT, CURR_VERSION, CURR_DEPT_CODE)"
                + "values(?, ?, ?, ?, ?,?,?,?,?,?)";
        Connection conn = DbConnection.getConn();
        PreparedStatement prstCurr = conn.prepareStatement(sqlInsertCurr);
        prstCurr.setString(1, curr.getField());
        prstCurr.setString(2, curr.getNomc());
        prstCurr.setString(3, curr.getNomcAm());
        prstCurr.setString(4, curr.getProgram());
        prstCurr.setString(5, curr.getAdmission());
        prstCurr.setInt(6, curr.getYear());
        prstCurr.setInt(7, curr.getSemester());
        prstCurr.setInt(8, curr.getMinCredit());
        prstCurr.setString(9, curr.getVersion());
        prstCurr.setInt(10, deptCode);
        int affectedRow = prstCurr.executeUpdate();
        return affectedRow > 0;
    }

    public ArrayList<Curriculum> getCurriculumList(int deptCode) throws Exception {
        ArrayList<Curriculum> currList = new ArrayList<>();
        String sqlSelectCurr = "Select CURR_CODE, EN_NOMENCLATURE, CURR_VERSION from CURRICULUM where CURR_DEPT_CODE = ?";
        Connection conn = DbConnection.getConn();
        PreparedStatement prstCurr = conn.prepareStatement(sqlSelectCurr);
        prstCurr.setInt(1, deptCode);
        ResultSet rstCurr = prstCurr.executeQuery();
        while (rstCurr.next()) {
            Curriculum curr = new Curriculum();
            curr.setCode(rstCurr.getInt("CURR_CODE"));
            curr.setNomc(rstCurr.getString("EN_NOMENCLATURE"));
            curr.setVersion(rstCurr.getString("CURR_VERSION"));
            currList.add(curr);
        }
        return currList;
    }
    
    public boolean updateCurriculum(Curriculum curr){
        return false;
    }
}
