package `in`.bantu.Login

import `in`.bantu.Dashboard.Dashboard
import `in`.bantu.MainActivity
import `in`.bantu.R
import `in`.bantu.ui.Signup.Signup
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login_tr.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.verification_signin.*
import org.jetbrains.anko.toast
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var mobileNumber: String = ""
    var mobileFirst: String = ""
    var verificationID: String = ""
    var token_: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_tr)

        mAuth = FirebaseAuth.getInstance()

        btnSignIn.setOnClickListener (View.OnClickListener{
            mobileFirst = etNumber.text.toString()
            mobileNumber = validateNumber(etNumber.text.toString())

            if (mobileNumber.length > 0) {
                progressBar.visibility = View.VISIBLE
                loginTask()
            } else {
                etNumber.setError("Enter valid phone number")
            }

        })
        Btn_signup.setOnClickListener(View.OnClickListener{
            val signup = Intent(this@LoginActivity,Signup::class.java)
            signup.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(signup)
            finish()
        })
    }
    private fun validateNumber(number:String):String{
        if(number[0]!='+'){
            number.replaceFirst("08","+628")
        }
        return number
    }
    private fun loginTask() {
        Log.e("Galih",mobileNumber)
        var mCallBacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential?) {
                if (credential != null) {
                    v_sign_progress.visibility = View.VISIBLE
                    signInWithPhoneAuthCredential(credential)
                }
            }

            override fun onVerificationFailed(p0: FirebaseException?) {
                progressBar.visibility = View.GONE
                toast("Invalid phone number or verification failed.")
                Log.e("Galih",""+p0!!.message)
            }

            override fun onCodeSent(verificationId: String?, token: PhoneAuthProvider.ForceResendingToken?) {
                super.onCodeSent(verificationId, token)
                progressBar.visibility = View.GONE
                verificationID = verificationId.toString()
                token_ = token.toString()
                /*
                etNumber.setText("")

                etNumber.setHint("Enter OTP ")
                btnSignIn.setText("Verify OTP")

                btnSignIn.setOnClickListener {
                    progressBar.visibility = View.VISIBLE
                    verifyAuthentication(verificationID, etNumber.text.toString())
                }*/
                container_signin.visibility = View.GONE
                setContentView(R.layout.verification_signin)
                phone_signin.text = mobileFirst
                submit_btn_signin.setOnClickListener{
                    v_sign_progress.visibility = View.VISIBLE
                    verifyAuthentication(verificationID,ver_edit_signin.text.toString())
                }
                Log.e("Login : verificationId ", verificationId)
                Log.e("Login : token ", token_)

            }

            override fun onCodeAutoRetrievalTimeOut(verificationId: String?) {
                super.onCodeAutoRetrievalTimeOut(verificationId)
                progressBar.visibility = View.GONE
                // toast("Time out")
            }
        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobileNumber,            // Phone number to verify
                60,                  // Timeout duration
                TimeUnit.SECONDS,        // Unit of timeout
                this,                // Activity (for callback binding)
                mCallBacks);

    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {

        mAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(this@LoginActivity, object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful()) {
                            val user = task.getResult().getUser()
//                            progressBar.visibility = View.GONE
                            v_sign_progress.visibility = View.GONE
                            val login = Intent(this@LoginActivity,Dashboard::class.java)
                            login.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK

                            startActivity(login)
                            finish()

                        } else {
                            if (task.getException() is FirebaseAuthInvalidCredentialsException) {
                                progressBar.visibility = View.GONE
                                toast("Invalid Code")
                            }
                        }
                    }
                })
    }

    private fun verifyAuthentication(verificationID: String, otpText: String) {

        val phoneAuthCredential = PhoneAuthProvider.getCredential(verificationID, otpText) as PhoneAuthCredential
        signInWithPhoneAuthCredential(phoneAuthCredential)
    }
}
