package com.study.javamind.controller;

import com.study.javamind.result.BaseResult;
import com.study.javamind.vo.ResultSetVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 能医健康测评
 */
@RestController
@Api(tags = "健康测评结果返回接口")
@RequestMapping("/api/op/dccard/assessment")
public class AssessmentController {

    private static Logger logger = LoggerFactory.getLogger(AssessmentController.class);

    @ApiOperation("结果返回")
    @PostMapping(value = "/evaluation")
    public BaseResult<String> evaluationResults(ResultSetVo param){
        String[] results = param.getResultStr().split(",");
        //阳虚质条目
        int[] entry1 = new int[]{19,20,21,23,24,53,56};
        double originalScore1  = statistical(entry1,results,true);
        //阳虚质转化分
        double conversionScore1 = calculate(originalScore1,entry1.length);

        //阴虚质条目
        int[] entry2 = new int[]{18,22,30,36,39,45,47,58};
        double originalScore2  = statistical(entry2,results,true);
        //阴虚质转化分
        double conversionScore2 = calculate(originalScore2,entry2.length);

        //气虚质条目
        int[] entry3 = new int[]{3,4,5,6,7,8,24,28};
        double originalScore3  = statistical(entry3,results,true);
        //气虚质转化分
        double conversionScore3 = calculate(originalScore3,entry3.length);

        //痰湿质条目
        int[] entry4 = new int[]{15,17,29,43,50,51,52,59};
        double originalScore4  = statistical(entry4,results,true);
        //痰湿质转化分
        double conversionScore4 = calculate(originalScore4,entry4.length);

        //湿热质条目
        int[] entry5 = new int[]{40,42,49,57,60,61};
        double originalScore5  = statistical(entry5,results,true);
        //湿热质转化分
        double conversionScore5 = calculate(originalScore5,entry5.length);

        //血瘀质条目
        int[] entry6 = new int[]{9,34,37,38,41,44,46};
        double originalScore6  = statistical(entry6,results,true);
        //血瘀质转化分
        double conversionScore6 = calculate(originalScore6,entry6.length);

        //特禀质条目
        int[] entry7 = new int[]{25,26,27,31,32,33,35};
        double originalScore7  = statistical(entry7,results,true);
        //特禀质转化分
        double conversionScore7 = calculate(originalScore7,entry7.length);

        //气郁质条目
        int[] entry8 = new int[]{10,11,12,13,14,16,48};
        double originalScore8  = statistical(entry8,results,true);
        //气郁质转化分
        double conversionScore8 = calculate(originalScore8,entry8.length);

        //平和质条目  反向计算
        int[] entry9 = new int[]{2,3,8,9,10,23,54,55};
        double originalScore9  = statistical(entry9,results,false);
        //平和质转化分
        double conversionScore9 = calculate(originalScore9,entry9.length);
        //转化分数组
        Double[] conversionScores = new Double[]{conversionScore1,conversionScore2,conversionScore3,conversionScore4,conversionScore5,conversionScore6,conversionScore7,conversionScore8,conversionScore9};
        //体质
        String physical = calculateResult(conversionScores);
        return BaseResult.success(physical);
    }

    /**
     * 通过各转化分计算所属体质
     * 计算规则：如果平和质转化分>=60,则为平和质,否则为其他体质,取其他体质转化分最高的
     * @param param
     * @return
     */
    private String calculateResult(Double[] param) {
        String physical = null;
        //param[8]为平和质转化分
        if(param[8] >= 60){
            physical = "平和质";
        }else {
            if(param.length>0) {
                double max = param[0];
                int index = 0;
                for (int i = 0; i < param.length; i++) {
                    if (param[i] > max) {//比较后赋值
                        max = param[i];
                        index = i;
                    }
                }
                switch (index){
                    case 0:
                        physical = "阳虚质";
                        break;
                    case 1:
                        physical = "阴虚质";
                        break;
                    case 2:
                        physical = "气虚质";
                        break;
                    case 3:
                        physical = "痰湿质";
                        break;
                    case 4:
                        physical = "湿热质";
                        break;
                    case 5:
                        physical = "血瘀质";
                        break;
                    case 6:
                        physical = "特禀质";
                        break;
                    case 7:
                        physical = "气郁质";
                        break;
                    default:
                        physical = "无符合体质";
                }
            }
        }
        return physical;
    }

    /**
     * 计算转化分
     * @param score
     * @param count
     * @return
     */
    private double calculate(double score,int count) {
        // 各个体质转化分数=[（各个体质原始分- 各个体质条目数）/（各个体质条目数×4）] ×100
        if("0".equals(String.valueOf(count)) || "null".equals(String.valueOf(count)) || count <= 0){
            System.out.println("体质条目数为0！count=" + count);
        }
        double conversionScore = ((score-count)/(count*4))*100;
        return conversionScore;
    }

    /**
     * 计算原始分
     * @param entry
     * @param param
     * @param flag
     * @return
     */
    private double statistical(int[] entry,String[] param, boolean flag) {
        // A:1分  B：2分  C:3分  D：4分  E:5分
        double score = 0;
        for(int i = 0; i < entry.length; i++){
            String op = param[entry[i]-2];
            if(flag){
                switch (op){
                    case "A":
                        score = score + 1;
                        break;
                    case "B":
                        score = score + 2;
                        break;
                    case "C":
                        score = score + 3;
                        break;
                    case "D":
                        score = score + 4;
                        break;
                    case "E":
                        score = score + 5;
                        break;
                    default:
                        score = 0;
                }
            }else{
                switch (op){
                    case "A":
                        score = score + 5;
                        break;
                    case "B":
                        score = score + 4;
                        break;
                    case "C":
                        score = score + 3;
                        break;
                    case "D":
                        score = score + 2;
                        break;
                    case "E":
                        score = score + 1;
                        break;
                    default:
                        score = 0;
                }
            }

        }
        return score;
    }
}
