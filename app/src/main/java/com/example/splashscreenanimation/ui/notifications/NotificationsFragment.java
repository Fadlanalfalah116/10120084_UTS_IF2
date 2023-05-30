//Nim:10120084
//Nama:Fadlan Alfalah Baihaaqi
//Kelas:IF2

package com.example.splashscreenanimation.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.splashscreenanimation.DatabasePresenter;
import com.example.splashscreenanimation.R;

import java.text.SimpleDateFormat;
import java.util.Date;


public class NotificationsFragment extends Fragment {

    private TextView tvSelectedDate;
    private EditText etTitle, etCategory, etContent;

    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMM yyyy");

    private DatabasePresenter databasePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);

        // Inisialisasi komponen UI
        tvSelectedDate = rootView.findViewById(R.id.tvSelectedDate);
        etTitle = rootView.findViewById(R.id.etTitle);
        etCategory = rootView.findViewById(R.id.etCategory);
        etContent = rootView.findViewById(R.id.etContent);
        Button btnSaveNote = rootView.findViewById(R.id.btnSaveNote);
        CalendarView calendarView = rootView.findViewById(R.id.calendarView);

        // Atur tanggal terpilih saat pertama kali fragment dibuka
        Date currentDate = new Date();
        tvSelectedDate.setText(dateFormatter.format(currentDate));

        // Atur listener pada calendarView untuk mengubah tanggal terpilih
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // Konversi tanggal terpilih menjadi format yang diinginkan
            Date selectedDate = new Date(year - 1900, month, dayOfMonth);
            tvSelectedDate.setText(dateFormatter.format(selectedDate));
        });

        // Inisialisasi databasePresenter
        databasePresenter = new DatabasePresenter(getActivity());

        // Atur listener pada tombol Save untuk menyimpan catatan harian
        btnSaveNote.setOnClickListener(v -> {
            // Dapatkan nilai-nilai input dari pengguna
            String title = etTitle.getText().toString().trim();
            String category = etCategory.getText().toString().trim();
            String content = etContent.getText().toString().trim();
            String selectedDate = tvSelectedDate.getText().toString().trim();

            // Lakukan validasi input
            if (title.isEmpty() || category.isEmpty() || content.isEmpty()) {
                Toast.makeText(getActivity(), "Semua field harus diisi", Toast.LENGTH_SHORT).show();
                return;
            }

            // Panggil metode saveNoteToDatabase dari databasePresenter
            databasePresenter.saveNoteToDatabase(selectedDate, title, category, content);

            // Bersihkan input setelah catatan harian disimpan
            clearInputFields();
        });

        return rootView;
    }

    private void clearInputFields() {
        etTitle.setText("");
        etCategory.setText("");
        etContent.setText("");
    }
}
