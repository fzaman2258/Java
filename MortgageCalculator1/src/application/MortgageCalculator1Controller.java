package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MortgageCalculator1Controller 
{
	private int loanyears= 25; 			//25 by default

    @FXML
    private TextField customyearTextField;

    @FXML
    private TextField interestRateTextField;

    @FXML
    private Label loanDurationLabel;

    @FXML
    private TextField loanAmountTextField;

    @FXML
    private Slider loanDurationSlider;

    @FXML
    private TextField downPaymentTextField;

    @FXML
    private TextField purchasePriceTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) 
    {
    

	    	BigDecimal purchaseprice=new BigDecimal(purchasePriceTextField.getText());
	    	BigDecimal downpayment=new BigDecimal(downPaymentTextField.getText());
	    	BigDecimal loanamount= purchaseprice.subtract(downpayment);
	    	if(Integer.parseInt(purchasePriceTextField.getText()) < Integer.parseInt(downPaymentTextField.getText()) || Integer.parseInt(downPaymentTextField.getText())<0 || Integer.parseInt(purchasePriceTextField.getText())<0 )
	    	{
	    		System.out.println("You have inputted invalid arguments! Please enter again.");
	    	}
	    	else
	    	{
		    	loanAmountTextField.setText(""+loanamount);
		    	
		    	BigDecimal interest=new BigDecimal(interestRateTextField.getText());
		    	BigDecimal twelve= new BigDecimal(12*100);					// we will use this to get monthly interest
		    	BigDecimal one=new BigDecimal(1);
		    	BigDecimal monthlyinterest= interest.divide(twelve,8,RoundingMode.HALF_UP);
		    	BigDecimal oneplusinterest=monthlyinterest.add(one);				// this is in the formula (1+r)
		    	BigDecimal numerator=monthlyinterest.multiply(oneplusinterest.pow(loanyears*12));	//calculate numerator of formula
		    	BigDecimal denominator=(oneplusinterest.pow(loanyears*12)).subtract(one);
		    	BigDecimal monthlypayment=loanamount.multiply(numerator.divide(denominator,8,RoundingMode.HALF_UP));
		    	customyearTextField.setText(""+monthlypayment);
	    	}
  
    }
    public void initialize()
    {
    	loanDurationSlider.valueProperty().addListener
    	(
    		new ChangeListener<Number>()
	    	{
    			@Override
	    		public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue)
	    		{
	    			loanyears=newValue.intValue();
	    			loanDurationLabel.setText(""+loanyears);
	    		}
	    	}
    	);	
    }
}
