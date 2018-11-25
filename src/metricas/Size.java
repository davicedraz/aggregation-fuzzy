package metricas;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Size {

	public static void main(String[] args) throws Exception {
		String filename = "Size.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}
		
		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		JFuzzyChart.get().chart(fb);
		
		// Set inputs

		System.out.println("Smart-phone");
		
		fb.setVariable("NF", 22);
		//fb.setVariable("NM", 2);
		//fb.setVariable("NTop", );
		fb.setVariable("NLeaf", 15);
		fb.setVariable("DTMax", 5);
		//fb.setVariable("CogC", 5);
		//fb.setVariable("FEX", );
		//fb.setVariable("FoC", 0.227272727272727);
		//fb.setVariable("SCDF", );
		//fb.setVariable("MCDF", );
		//fb.setVariable("RDen", 1.66666666666667);
		//fb.setVariable("RoV", 2.16666666666667);
		//fb.setVariable("NVC", );
		//fb.setVariable("NGOr", );
		//fb.setVariable("NGXOr", );
		
		
		// Evaluate
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("SIFM").defuzzify();

		// Print ruleSet
		System.out.println(fb);
		System.out.println(fb.getVariable("SIFM").getValue());
		
		// Show each rule (and degree of support)
	    for( Rule r : fis.getFunctionBlock("size_index").getFuzzyRuleBlock("No1").getRules() )
	      System.out.println(r);
		
		Variable tip = fb.getVariable("SIFM");
		JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
	
	}

}

