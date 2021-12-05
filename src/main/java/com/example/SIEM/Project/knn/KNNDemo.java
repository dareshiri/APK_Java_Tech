package com.example.SIEM.Project.knn;

import com.example.SIEM.Project.KNN;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class KNNDemo {

    /**
     * This method is to load the data set.
     * @param fileName
     * @return
     * @throws IOException
     */
    public static Instance getDataSet(String fileName) throws IOException {
        int classIdx = 1;
        ArffLoader loader = new ArffLoader();
        loader.setSource(KNNDemo.class.getResourceAsStream(fileName));
        /**
         * we can also set the file like loader3.setFile(new
         * File("test-confused.arff"));
         */
        loader.setFile(new File("test-confused.arff"));
        Instances dataSet = loader.getDataSet();
        /** set the index based on the data given in the arff files */
        dataSet.setClassIndex(classIdx);
        return (Instance) dataSet;
    }


    /**
     * @param
     * @throws Exception
     */
    public static void process() throws Exception {


        Instances data = (Instances) getDataSet("data.arff");
        data.setClassIndex(data.numAttributes() - 1);
        //k - the number of nearest neighbors to use for prediction
        Classifier ibk = new IBk(1);
        ibk.buildClassifier(data);

        System.out.println(ibk);

        Evaluation eval = new Evaluation(data);
        eval.evaluateModel(ibk, data);
        /** Print the algorithm summary */
        System.out.println("** KNN Demo  **");
        System.out.println(eval.toSummaryString());
        System.out.println(eval.toClassDetailsString());
        System.out.println(eval.toMatrixString());
    }

}
