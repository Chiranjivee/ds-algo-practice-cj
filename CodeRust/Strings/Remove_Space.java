class RemoveSpaces {

    public String removeSpaces(String input) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current != ' ' && current != '\t') {
                builder.append(current);
            }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        RemoveSpaces spaceRemover = new RemoveSpaces();
        System.out.println(spaceRemover.removeSpaces("   Test \t\twith spaces   "));
    }
}