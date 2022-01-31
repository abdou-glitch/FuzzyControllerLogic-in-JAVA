package com.FuzzyProject;

import java.io.FileInputStream;
import java.io.InputStream;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class myFuzzyClass {
	static FIS fis=null;
	public static void main(String[] args) throws Exception {
		
		  InputStream is=new FileInputStream("/home/abdelghafar/eclipse-workspace/FuzzyProject/src/Naturallight.fcl");
		   fis=FIS.load(is,true);

	        // Error while loading?
	        if( fis == null ) { 
	            System.err.println("Can't load file: '" + "Naturallight.fcl" + "'");
	            return;
	        }
	       
	        
	     //   FunctionBlock fb = fis.getFunctionBlock(null);
	        
	        //fb.chart();
	        
			fis.setVariable("NaturalLight", 1);
	        
			fis.evaluate();
	        
	        //fb.getVariable("NaturalLight").chartDefuzzifier(true);
			 FunctionBlock functionBlock = fis.getFunctionBlock(null);
	        Variable Lamp = functionBlock.getVariable("Lamp");
	        JFuzzyChart.get().chart(Lamp, Lamp.getDefuzzifier(), true);
	        
	       
	        
			JFuzzyChart.get().chart(functionBlock);
	        // Print ruleSet
	        System.out.println(fis);
	}

}
