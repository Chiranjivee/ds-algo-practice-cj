public class ReplaceCharacterRecursively
{
    public static String 
        replaceCharacter(
            String input, 
            char c1, 
            char c2)
    {
      	StringBuilder result = new StringBuilder(input);
		return replaceCharacterUtil(result, 0, c1, c2).toString();
	}

  	public static StringBuilder 
      replaceCharacterUtil(
      	StringBuilder input,
      	int idx,
      	char c1,
      	char c2)
    {
      	if (input.length() == idx)
        {
          	return input;
        }
      	
      	if (input.charAt(idx) != c1)
        {
          	return replaceCharacterUtil(input, ++idx, c1, c2);
        }
        
        input.setCharAt(idx, c2);
        return replaceCharacterUtil(input, ++idx, c1, c2);
    }
}
