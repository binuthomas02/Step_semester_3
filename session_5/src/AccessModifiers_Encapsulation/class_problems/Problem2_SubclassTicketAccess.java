public class Problem2_SubclassTicketAccess {

    public static void main(String[] args) {
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }

    static String classifyAccess(String fieldModifier, String accessorContext) {
        boolean allowed;

        if (fieldModifier.equals("private")) {
            allowed = accessorContext.equals("SAME_CLASS");
        } else if (fieldModifier.equals("default")) {
            allowed = accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE");
        } else if (fieldModifier.equals("protected")) {
            // Cross-package protected access is only granted when the reference's
            // DECLARED type is the subclass itself (OWN_TYPE), not the parent type.
            allowed = accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")
                    || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE");
        } else if (fieldModifier.equals("public")) {
            allowed = true;
        } else {
            allowed = false;
        }

        return allowed ? "ALLOWED" : "DENIED";
    }
}
