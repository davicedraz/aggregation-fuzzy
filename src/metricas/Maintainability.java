package metricas;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Maintainability {

	
	public static void main(String[] args) throws Exception{
		String filename = "Maintainability.fcl";

		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		JFuzzyChart.get().chart(fb);

		// Set inputs for the FM - Mobile Game

		fb.setVariable("NF", 22);
		fb.setVariable("NM", 2);
		//fb.setVariable("NTop", );
		fb.setVariable("NLeaf", 15);
		fb.setVariable("DTMax", 5);
		fb.setVariable("CogC", 5);
		//fb.setVariable("FEX", );
		fb.setVariable("FoC", 0.227272727272727);
		//fb.setVariable("SCDF", );
		//fb.setVariable("MCDF", );
		fb.setVariable("RDEn", 1.66666666666667);
		fb.setVariable("RoV", 2.16666666666667);
		//fb.setVariable("NVC", );
		//fb.setVariable("NGOr", );
		//fb.setVariable("NGXOr", );


		// Evaluate
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("MIFM").defuzzify();

		// Print ruleSet
		System.out.println(fb);
		System.out.println("Tip: " + fb.getVariable("MIFM").getValue());

		// Show each rule (and degree of support)
		for( Rule r : fis.getFunctionBlock("tipper").getFuzzyRuleBlock("No1").getRules() )
			System.out.println(r);

		Variable tip = fb.getVariable("MIFM");
		JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

	}

}
