public class RuleEngine {

    public static String evaluate(boolean policy, boolean docs, boolean accident) {

        if (!accident) {
            return "Rule: Accident not reported -> Claim Rejected";
        }

        if (policy && docs) {
            return "Rule: Policy active AND documents valid -> Claim Approved";
        }

        return "Rule: Conditions not satisfied -> Claim Rejected";
    }

    public static void main(String[] args) {
        System.out.println(evaluate(true, true, true));
    }
}