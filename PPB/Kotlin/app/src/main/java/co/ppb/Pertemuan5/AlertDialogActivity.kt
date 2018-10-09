package co.ppb.Pertemuan5

import android.app.Dialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.view.Window
import android.widget.Toast
import co.ppb.R
import kotlinx.android.synthetic.main.activity_alert_dialog.*
import kotlinx.android.synthetic.main.dialog_layout.*

class AlertDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        btnAlert1.setOnClickListener {
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this@AlertDialogActivity)

            // set message of alert dialog
            dialogBuilder.setMessage("Materi Dialog Mobile Programming")
                    // if the dialog is cancelable
                    .setIcon(R.drawable.foto1)
                    .setCancelable(false)
                    // positive button text and action
                    .setNeutralButton("OK",DialogInterface.OnClickListener{
                        dialog, id -> dialog.dismiss()
                    })
            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("AlertDialog")
            // show alert dialog
            alert.show()
        }
        btnAlert2.setOnClickListener {
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this@AlertDialogActivity)

            // set message of alert dialog
            dialogBuilder.setMessage("Yakin data dihapus ?")
                    // if the dialog is cancelable
                    .setCancelable(false)
                    // positive button text and action
                    .setPositiveButton("Yes", DialogInterface.OnClickListener{
                        dialog, id->
                        Toast.makeText(applicationContext,"Tombol Yes Ditekan",Toast.LENGTH_SHORT)
                        dialog.dismiss()
                    })
                    // negative button text and action
                    .setNegativeButton("No", DialogInterface.OnClickListener {
                        dialog, id ->
                        Toast.makeText(applicationContext,"Tombol Yes Ditekan",Toast.LENGTH_SHORT)
                        dialog.cancel()
                    })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Konfirmasi Hapus")
            // show alert dialog
            alert.show()
        }

        btnAlert3.setOnClickListener {
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this@AlertDialogActivity)

            // set message of alert dialog
            dialogBuilder.setMessage("Simpan File Pekerjaan ?")
                    // if the dialog is cancelable
                    .setCancelable(false)
                    // positive button text and action
                    .setPositiveButton("Yes", DialogInterface.OnClickListener {
                        dialog, id->
                        Toast.makeText(applicationContext,"Tombol Yes Ditekan",Toast.LENGTH_SHORT)
                        dialog.dismiss()

                    })
                    .setNeutralButton("No",DialogInterface.OnClickListener{
                        dialog, id-> Toast.makeText(applicationContext,"Tombol No Ditekan",Toast.LENGTH_SHORT)
                        dialog.cancel()

                    })
                    // negative button text and action
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id ->Toast.makeText(applicationContext,"Tombol Cancel Ditekan",Toast.LENGTH_SHORT)
                        dialog.cancel()

                    })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Simpan File")
            // show alert dialog
            alert.show()
        }
        btnAlert4.setOnClickListener {
            // build alert dialog
            val dialog :Dialog = Dialog(this@AlertDialogActivity)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_layout)
            dialog.btnOk.setOnClickListener(View.OnClickListener {
                dialog.dismiss()
            })
            dialog.show()
        }
    }
}
