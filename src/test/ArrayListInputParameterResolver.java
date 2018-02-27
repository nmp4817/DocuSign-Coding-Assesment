package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

class ArrayListInputParameterResolver implements ParameterResolver {

	@Override
	  public boolean supportsParameter(ParameterContext parameterContext, 
	    ExtensionContext extensionContext) throws ParameterResolutionException {
	      return parameterContext.getParameter().getType() == ArrayList.class;
	  }
	 
	  @Override
	  public Object resolveParameter(ParameterContext parameterContext, 
	    ExtensionContext extensionContext) throws ParameterResolutionException {
		  String[] input1 = {"HOT", "8", "6", "4", "2", "1", "7"};
			String[] input2 = {"COLD", "8", "6", "3", "4", "2", "5", "1", "7"};
			String[] input3 = {"HOT", "8", "6", "6"};
			String[] input4 = {"COLD", "8", "6", "3", "4", "2", "5", "7"};
			
			return new ArrayList<String[]>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{add(input1); add(input2); add(input3); add(input4);}
			};
	  }

}
