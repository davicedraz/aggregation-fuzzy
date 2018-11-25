package metricas;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Variability {

	public static void main(String[] args) throws Exception {
		String filename = "Variability.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}
		
		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		JFuzzyChart.get().chart(fb);
		
		// Set inputs

		fb.setVariable("NF", 49);
		fb.setVariable("NM", 17);
		fb.setVariable("FoC", 0.14);

		// Evaluate
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("VIFM").defuzzify();

		// Print ruleSet
		System.out.println(fb);
		System.out.println(fb.getVariable("VIFM").getValue());
		
		// Show each rule (and degree of support)
	    for( Rule r : fis.getFunctionBlock("variability_index").getFuzzyRuleBlock("No1").getRules() )
	      System.out.println(r);
		
		Variable tip = fb.getVariable("VIFM");
		JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
		
	}

}

