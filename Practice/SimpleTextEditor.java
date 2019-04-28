import java.util.Stack;
import java.util.Arrays;

class SimpleTextEditor {
    private StringBuilder state;

    private Stack<StringBuilder> undoStack;
    private Stack<StringBuilder> redoStack;

    public SimpleTextEditor() {
        this.state = new StringBuilder();
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void append(String word) {
        this.undoStack.push(new StringBuilder(this.state));
        this.state.append(word);
    }

    public void deleteKFromLast(int k) {
        this.undoStack.push(new StringBuilder(this.state));
        this.state.setLength(k > this.state.length() ? 0 : this.state.length() - k);
    }

    public void printKthCharacter(int k) {
        System.out.println(this.state.charAt(k - 1));
    }

    public void undo() {
        this.redoStack.push(this.state);
        this.state = this.undoStack.pop();
    }

    public void redo() {
        this.undoStack.push(new StringBuilder(this.redoStack.pop()));
        this.state = this.undoStack.peek();
    }

    public String getState() {
        return state.toString();
    }

    public static void main(String[] args) {
        String input1 = "1 abc;3 3;2 3;1 xy;3 2;4;5;3 1;";
        String input2 = "1 zsfncpxdzl;3 4;3 6;2 1;3 7;3 2;4;2 4;2 6;4;4;1 l;1 hpe;3 6;2 7;4;3 6;4;3 6;1 zipsqagri;1 vuqxstnj;4;3 13;4;3 10;3 6;1 uzdpy;1 bupqp;1 kn;2 6;3 8;1 iiuvfbn;4;2 1;2 12;4;3 7;4;2 9;3 1;1 axbhx;1 wovbfyvt;3 11;3 7;3 2;4;1 tjmqp;4;2 6;3 4;";
        String input3 = "1 a;1 b;1 c;4;1 d;4;5;1 e;";

        SimpleTextEditor textEditor = new SimpleTextEditor();
        String[] parts = input3.split(";");
        for (String part : parts ) {
            String[] operations = part.split(" ");

            int operationType = Integer.valueOf(operations[0]);
            switch (operationType) {
                case 1: 
                    textEditor.append(operations[1]);
                    break;
                case 2: 
                    textEditor.deleteKFromLast(Integer.valueOf(operations[1]));
                    break;
                case 3: 
                    textEditor.printKthCharacter(Integer.valueOf(operations[1]));
                    break;
                case 4: 
                    textEditor.undo();
                    break;
                case 5: 
                    textEditor.redo();
                    break;
            }
        }
        System.out.println(textEditor.getState());
    }
}
