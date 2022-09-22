package tw.tylu.action;

import java.util.ArrayList;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import tw.tylu.model.TruckBean;

public class DemoSpelAction {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();

		Expression express1 = parser.parseExpression("'Hola'+' Amigo!!'");
		String result1 = express1.getValue().toString();
		System.out.println("result1: " + result1);

		Expression express2 = parser.parseExpression("2*3+1");
		Integer result2 = express2.getValue(Integer.class);
		System.out.println("result2+1: " + (result2 + 1));
		
		
		EvaluationContext ectx = new StandardEvaluationContext();
		
		TruckBean truck1 = new TruckBean(101, "ford");
		TruckBean truck2 = new TruckBean(102, "honda");
		
		ArrayList<TruckBean> trucks = new ArrayList<TruckBean>();
		trucks.add(truck1);
		trucks.add(truck2);
		
		ectx.setVariable("trucks", trucks);
		String brand = parser.parseExpression("#trucks[0].brand").getValue(ectx, String.class); // ArrayList 中的第一筆(ford)
		String id = parser.parseExpression("#trucks[1].id").getValue(ectx, String.class); // ArrayList 中的第二筆(honda)
		System.out.println("Brand: "+brand);
		System.out.println("Id: "+id);
	}

}
