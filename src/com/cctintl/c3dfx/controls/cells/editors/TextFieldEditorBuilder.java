package com.cctintl.c3dfx.controls.cells.editors;

import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import com.cctintl.c3dfx.controls.C3DTextField;
import com.cctintl.c3dfx.controls.cells.editors.base.EditorNodeBuilder;

public class TextFieldEditorBuilder implements EditorNodeBuilder<String> {

	private C3DTextField textField;

	@Override
	public void startEdit() {
		Platform.runLater(()->{
			textField.selectAll();
			textField.requestFocus();
		});
	}

	@Override
	public void cancelEdit() {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateItem(String item, boolean empty) {
		Platform.runLater(()->{
			textField.selectAll();
			textField.requestFocus();
		});
	}

	@Override
	public Region createNode(String value, DoubleBinding minWidthBinding, EventHandler<KeyEvent> keyEventsHandler, ChangeListener<Boolean> focusChangeListener) {
		StackPane pane = new StackPane();
		pane.setStyle("-fx-padding:-10 -8 -10 -8");
		textField = new C3DTextField(value);
		textField.setStyle("-fx-background-color:TRANSPARENT;");
		textField.minWidthProperty().bind(minWidthBinding);
		textField.setOnKeyPressed(keyEventsHandler);
		textField.focusedProperty().addListener(focusChangeListener);
		pane.getChildren().add(textField);
		return pane;
	}

	@Override
	public void setValue(String value) {
		textField.setText(value);
	}

	@Override
	public String getValue() {
		return textField.getText();
	}

	@Override
	public void validateValue() throws Exception {
		
	}


}
