package ua.com.schoolnetwork.editor;

import ua.com.schoolnetwork.service.interfaces.DialogService;

import java.beans.PropertyEditorSupport;

/**
 * Created by ваня on 22.04.2017.
 */
public class DialogEditor extends PropertyEditorSupport {
    private final DialogService dialogService;

    public DialogEditor(DialogService dialogService) {
        this.dialogService = dialogService;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(dialogService.findOne(Integer.parseInt(text)));
    }
}
