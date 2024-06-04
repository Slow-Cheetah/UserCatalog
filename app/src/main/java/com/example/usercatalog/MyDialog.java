package com.example.usercatalog;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDialog {
    public static void openDialog(
            Context context,
            int position,
            ArrayAdapter adapter,
            ArrayList<User> catalog
    ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Внимание!")
                .setMessage("Удалить пользователя?")
                .setCancelable(false)
                .setNegativeButton("Нет", ((dialog, which) -> {
                    dialog.cancel();
                    Toast.makeText(context, "Удаление отменено", Toast.LENGTH_SHORT).show();
                }))
                .setPositiveButton("Да", ((dialog, which) -> {
                    catalog.remove(position);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(context, "Пользователь удален", Toast.LENGTH_SHORT).show();
                }));
        builder.create().show();

    }
}
