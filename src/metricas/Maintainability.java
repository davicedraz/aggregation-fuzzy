package metricas;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
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

//		fb.setVariable("NF", 43);	fb.setVariable("NM", 22);	fb.setVariable("NTop", 3);		fb.setVariable("NLeaf", 32);	fb.setVariable("DTMax", 4);		fb.setVariable("CogC", 5);		fb.setVariable("FEX", 32);		fb.setVariable("FoC", 0.13);		fb.setVariable("SCDF", 0);		fb.setVariable("MCDF", 0);		fb.setVariable("RDen", 0);		fb.setVariable("RoV", 2.93);		fb.setVariable("NVC", 23040);	fb.setVariable("NGOr", 4);		fb.setVariable("NGXOr", 1);		fb.evaluate();

		fb.setVariable("NF", 10);	fb.setVariable("NM", 3);	fb.setVariable("NTop", 4);		fb.setVariable("NLeaf", 7);		fb.setVariable("DTMax", 3);		fb.setVariable("CogC", 2);		fb.setVariable("FEX", 7);		fb.setVariable("FoC", 0.1);			fb.setVariable("SCDF", 0);		fb.setVariable("MCDF", 0);		fb.setVariable("RDen", 0);		fb.setVariable("RoV", 2.2);			fb.setVariable("NVC", 28);		fb.setVariable("NGOr", 1);		fb.setVariable("NGXOr", 1);		fb.evaluate();

		
		// Evaluate
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("MIFM").defuzzify();

		// Print ruleSet
		System.out.println(fb);
		System.out.println(fb.getVariable("MIFM").getValue());

		// Show each rule (and degree of support)

		Variable newMeasure = fb.getVariable("MIFM");
		JFuzzyChart.get().chart(newMeasure, newMeasure.getDefuzzifier(), true);
	}

}
