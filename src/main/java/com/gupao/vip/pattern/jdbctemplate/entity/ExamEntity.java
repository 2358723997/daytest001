package com.gupao.vip.pattern.jdbctemplate.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class ExamEntity {
    private Long id;
    private String userName;
    private Long examTime;
    private Double totalScore;


    public Exam toExam(){
        Exam result = new Exam();
        // TODO: 2019-05-18
        result.setExamTime(this.examTime);
        result.setId(this.id);
        result.setTotalScore(this.totalScore);
        result.setUserName(this.userName);
        return result;
    }

    public <T,M> T toEntity(M entity,Class<T> clazz){
        String  json = JSONObject.toJSONString(entity);
        T result = JSONObject.parseObject(json, clazz);
        return result;
    }

    public static void main(String[] args) {
        ExamEntity entity = new ExamEntity();
        entity.setExamTime(124l);
        entity.setUserName("xiaowang");
        Exam exam = entity.toEntity(entity, Exam.class);
        System.err.println(JSON.toJSONString(exam));
    }
}
