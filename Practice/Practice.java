import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
	private static Map<String, OperationType> 
		availableOperationsMap = new HashMap<>();
	static {
		availableOperationsMap.put("+", OperationType.PLUS);
		availableOperationsMap.put("-", OperationType.MINUS);
		availableOperationsMap.put("/", OperationType.DIVIDE);
		availableOperationsMap.put("*", OperationType.MULTIPLY);
		availableOperationsMap.put("%", OperationType.MOD);
	}

	enum OperationType {
		PLUS("+") {
			public void operate(int a, int b) {
				System.out.println(a + " + " + b + " = " + (a + b));
			}
		},
		MINUS("-") {
			public void operate(int a, int b) {
				System.out.println(a + " - " + b + " = " + (a - b));
			}
		},
		DIVIDE("/") {
			public void operate(int a, int b) {
				double aa = a;
				double bb = b;
				System.out.println(a + " / " + b + " = " + (aa / bb));
			}
		},
		MULTIPLY("*") {
			public void operate(int a, int b) {
				System.out.println(a + " * " + b + " = " + (a * b));
			}
		},
		MOD("%") {
			public void operate(int a, int b) {
				System.out.println(a + " % " + b + " = " + (a % b));
			}
		},
		NO_OP("NILL") {
			public void operate(int a, int b) {
				System.out.println("Invalid operation between: " + a + " & " + b);
			}
		};

		String op;
		OperationType(String op) {
			this.op = op;
		}

		static OperationType fromOp(String op) {
			try {
				return availableOperationsMap.get(op);
			} catch (Exception e) {
				return OperationType.NO_OP;
			}
		}
		abstract void operate(int a, int b);
	}

	public void execute(Integer a, OperationType op, Integer b) {
		op.operate(a, b);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter expressions to evalute or q to exit ");
		for (;;) {
			try {
				String input = sc.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(input);
				if (tokenizer.countTokens() == 1 && tokenizer.nextToken().equalsIgnoreCase("q")) {
					break;
				}

				if (tokenizer.countTokens() != 3) {
					throw new IllegalArgumentException("Invalid expression.");
				}
				sol.execute(
					sol.parseInteger(tokenizer.nextToken()),
					OperationType.fromOp(tokenizer.nextToken()),
					sol.parseInteger(tokenizer.nextToken()));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Integer parseInteger(String number) {
		try {
			return Integer.valueOf(number);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("'" + number +  "' is not a valid integer.");
		}
	}
}
