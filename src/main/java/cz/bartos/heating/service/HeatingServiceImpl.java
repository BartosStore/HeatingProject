package cz.bartos.heating.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import org.antlr.runtime.RecognitionException;

@Stateless
public class HeatingServiceImpl implements HeatingService {

    private FunctionBlock functionBlock;
    private static final String fuzzyDefinition = "/*\n"
            + "	Example: A tip calculation FIS (fuzzy inference system)\n"
            + "	Calculates tip based on 'servie' and 'food'\n"
            + "\n"
            + "	If you want to about this example (and fuzzy logic), please \n"
            + "	read Matlab's tutorial on fuzzy logic toolbox \n"
            + "	http://www.mathworks.com/access/helpdesk/help/pdf_doc/fuzzy/fuzzy.pdf\n"
            + "\n"
            + "									Pablo Cingolani \n"
            + "									pcingola@users.sourceforge.net\n"
            + "*/\n"
            + "\n"
            + "\n"
            + "\n"
            + "FUNCTION_BLOCK heating // Block definition (there may be more than one block per file)\n"
            + "\n"
            + "\n"
            + "\n"
            + "VAR_INPUT				// Define input variables\n"
            + "	\n"
            + "airtemp : REAL;\n"
            + "\n"
            + "\n"
            + "END_VAR\n"
            + "\n"
            + "VAR_OUTPUT				// Define output variable\n"
            + "	\n"
            + "heating : REAL;\n"
            + "\n"
            + "\n"
            + "END_VAR\n"
            + "\n"
            + "FUZZIFY airtemp			// Fuzzify input variable 'service': {'poor', 'good' , 'excellent'}\n"
            + "	\n"
            + "TERM LOW := (16, 0) (19, 1) (22, 0); \n"
            + "	\n"
            + "TERM MEDIUM := (19, 0) (22, 1) (25, 0);\n"
            + "	\n"
            + "TERM HIGH := (22, 0) (25, 1) (28, 0);\n"
            + "\n"
            + "\n"
            + "END_FUZZIFY\n"
            + "\n"
            + "DEFUZZIFY heating		// Defzzzify output variable 'tip' : {'cheap', 'average', 'generous' }\n"
            + "	\n"
            + "TERM LOW := (30,0) (45,1) (60,0);\n"
            + "	\n"
            + "TERM AVERAGE := (45,0) (55,1) (60,1) (75,0);\n"
            + "	\n"
            + "TERM HIGH := (60,0) (75,1) (90,0);\n"
            + "	\n"
            + "METHOD : COG;		// Use 'Center Of Gravity' defuzzification method\n"
            + "	\n"
            + "DEFAULT := 0;		// Default value is 0 (if no rule activates defuzzifier)\n"
            + "\n"
            + "\n"
            + "END_DEFUZZIFY\n"
            + "\n"
            + "RULEBLOCK No1\n"
            + "	\n"
            + "AND : MIN;			// Use 'min' for 'and' (also implicit use 'max' for 'or' to fulfill DeMorgan's Law)\n"
            + "	\n"
            + "ACT : MIN;			// Use 'min' activation method\n"
            + "	\n"
            + "ACCU : MAX;			// Use 'max' accumulation method\n"
            + "\n"
            + "	\n"
            + "\n"
            + "RULE 1 : if airtemp is LOW then heating is LOW;\n"
            + "RULE 2 : if airtemp is MEDIUM then heating is AVERAGE;\n"
            + "RULE 3 : if airtemp is HIGH then heating is HIGH;\n"
            + "END_RULEBLOCK\n"
            + "\n"
            + "END_FUNCTION_BLOCK\n"
            + "";

    @PostConstruct
    private void postConstruct() {
        FIS fis = null;
        try {
            fis = FIS.createFromString(fuzzyDefinition, false);
        } catch (RecognitionException ex) {
            Logger.getLogger(HeatingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        functionBlock = fis.getFunctionBlock(null);
    }

    @Override
    public double process(double inputTemperature) {
        functionBlock.setVariable("airtemp", inputTemperature);
        functionBlock.evaluate();
        functionBlock.getVariable("heating").defuzzify();
        return functionBlock.getVariable("heating").getValue();

    }

}
