/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrarlib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ChalewT
 */
public class Course {
    int id;
    String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    String title;
    int credit;
    int lecture;
    int labratory;
    int tutor;
    int homeStudy;
    int deliveryYear;
    int deliverySemester;
    String catagory;
    String offerOption;
    int currCode;
    int ownerDept;
    
    //<editor-fold defaultstate="collapsed" desc="Getter and setter">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getLecture() {
        return lecture;
    }

    public void setLecture(int lecture) {
        this.lecture = lecture;
    }

    public int getLabratory() {
        return labratory;
    }

    public void setLabratory(int labratory) {
        this.labratory = labratory;
    }

    public int getTutor() {
        return tutor;
    }

    public void setTutor(int tutor) {
        this.tutor = tutor;
    }

    public int getHomeStudy() {
        return homeStudy;
    }

    public void setHomeStudy(int homeStudy) {
        this.homeStudy = homeStudy;
    }

    public int getDeliveryYear() {
        return deliveryYear;
    }

    public void setDeliveryYear(int deliveryYear) {
        this.deliveryYear = deliveryYear;
    }

    public int getDeliverySemester() {
        return deliverySemester;
    }

    public void setDeliverySemester(int deliverySemester) {
        this.deliverySemester = deliverySemester;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getOfferOption() {
        return offerOption;
    }

    public void setOfferOption(String offerOption) {
        this.offerOption = offerOption;
    }

    public int getCurrCode() {
        return currCode;
    }

    public void setCurrCode(int currCode) {
        this.currCode = currCode;
    }

    public int getOwnerDept() {
        return ownerDept;
    }

    public void setOwnerDept(int ownerDept) {
        this.ownerDept = ownerDept;
    }
    
    //</editor-fold>
    
    //Methods
    public boolean registerCourse(Course course) throws Exception{
        String sqlInsertCourse="Insert into COURSE( COURSE_CODE, TITLE, CREDIT, LECTURE, "
                + "LABORATORY,TUTOR, HOME_STUDY, DELIVER_YEAR, DELIVER_SEMESTER, CATAGORY "
                + ", OFFER_OPTION, COURSE_CURR_CODE, OWNER_DEPT_CODE)"
                + "values(?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)";
        Connection conn = DbConnection.getConn();
        PreparedStatement prstCourse = conn.prepareStatement(sqlInsertCourse);
        //Set parameters
        prstCourse.setString(1, course.getCode());
        prstCourse.setString(2, course.getTitle());
        prstCourse.setInt(3, course.getCredit());
        prstCourse.setInt(4, course.getLecture());
        prstCourse.setInt(5, course.getLabratory());
        prstCourse.setInt(6, course.getTutor());
        prstCourse.setInt(7, course.getHomeStudy());
        prstCourse.setInt(8, course.getDeliveryYear());
        prstCourse.setInt(9, course.getDeliverySemester());
        prstCourse.setString(10, course.getCatagory());
        prstCourse.setString(11, course.getOfferOption());
        prstCourse.setInt(12, course.getCurrCode());
        prstCourse.setInt(13, course.getOwnerDept());
        //execute
        int affectedRow = prstCourse.executeUpdate();
        return affectedRow > 0;
    }
    
    public Course getCourseByCode(String code){
        Course course = new Course();
        
        return course;
    }
    
    public ArrayList<Course> getCourseByCurriculum(int curriculumCode){
        ArrayList<Course> courseList = new ArrayList<Course>();
        
        return courseList;
    }
}
