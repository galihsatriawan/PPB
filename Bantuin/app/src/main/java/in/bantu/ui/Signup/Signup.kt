package `in`.bantu.ui.Signup

import `in`.bantu.Dashboard.Dashboard
import `in`.bantu.Login.LoginActivity
import `in`.bantu.MainActivity
import `in`.bantu.R

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
import kotlinx.android.synthetic.main.verification_signup.*
import org.jetbrains.anko.toast
import java.util.concurrent.TimeUnit

class Signup : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var mobileNumber: String = ""
    var mobileFirst : String = ""
    var verificationID: String = ""
    var token_: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mAuth = FirebaseAuth.getInstance()

        btn_register.setOnClickListener (View.OnClickListener{

            mobileNumber = validateNumber(phone_signup.text.toString())
            mobileFirst = phone_signup.text.toString()

            if (mobileNumber.length > 0) {
                progressBarUp.visibility = View.VISIBLE
                loginTask()
            } else {
                phone_signup.error = "Enter valid phone number"
            }
        })
        btn_login.setOnClickListener(View.OnClickListener{
            val login= Intent(this@Signup,LoginActivity::class.java)
            login.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(login)
            finish()
        })
    }

    private fun loginTask() {
        Log.e("Galih",mobileNumber)
        var mCallBacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential?) {
                if (credential != null) {
                    v_sign_up_progress.visibility = View.VISIBLE
                    signInWithPhoneAuthCredential(credential)
                }
            }

            override fun onVerificationFailed(p0: FirebaseException?) {
                progressBarUp.visibility = View.GONE
                toast("Invalid phone number or verification failed.")
                Log.e("Galih",""+p0!!.message)
            }

            override fun onCodeSent(verificationId: String?, token: PhoneAuthProvider.ForceResendingToken?) {
                super.onCodeSent(verificationId, token)
                progressBarUp.visibility = View.GONE
                verificationID = verificationId.toString()
                token_ = token.toString()

                /*
                phone_signup.setText("")

                phone_signup.setHint("Enter OTP ")
                btnSignIn.setText("Verify OTP")

                btnSignIn.setOnClickListener {
                    progressBarUp.visibility = View.VISIBLE
                    verifyAuthentication(verificationID, phone_signup.text.toString())
                }*/
                container_signup.visibility = View.GONE
                setContentView(R.layout.verification_signup)
                txtPhone_signup.text = mobileFirst
                submit_btn_signin.setOnClickListener{
                    v_sign_up_progress.visibility = View.VISIBLE
                    verifyAuthentication(verificationID,ver_edit_signup.text.toString())
                }
                Log.e("Login : verificationId ", verificationId)
                Log.e("Login : token ", token_)

            }

            override fun onCodeAutoRetrievalTimeOut(verificationId: String?) {
                super.onCodeAutoRetrievalTimeOut(verificationId)
                progressBarUp.visibility = View.GONE
                // toast("Time out")
            }
        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobileNumber,            // Phone number to verify
                60,                  // Timeout duration
                TimeUnit.SECONDS,        // Unit of timeout
                this,                // Activity (for callback binding)
                mCallBacks)

    }
    private fun validateNumber(number:String):String{
        if(number[0]=='8'){
            number.replaceFirst("8","+628")
        }else if(number[0] == '0'){
            number.replaceFirst("08","+628")
        }
        return number
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {

        mAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(this@Signup, object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful) {
                            val user = task.result.user
//                            progressBarUp.visibility = View.GONE
                            v_sign_up_progress.visibility = View.GONE
                            val login = Intent(this@Signup,Dashboard::class.java)
                            login.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(login)
                            finish()

                        } else {
                            if (task.exception is FirebaseAuthInvalidCredentialsException) {
                                progressBarUp.visibility = View.GONE
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
