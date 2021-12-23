package com.example.instagram

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.instagram.Models.Users
import com.example.instagram.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {
    private  lateinit var binding: ActivitySignupBinding
    private  lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.SignBtn.setOnClickListener {
            val fullname = binding.fullNameSignup.text.toString()
        val username = binding.userNameSignup.text.toString()
        val email = binding.emailSignup.text.toString()
        val password = binding.passwordSignup.text.toString()
        //  CreateAccount()
database = FirebaseDatabase.getInstance().getReference("Users")


val Users = Users(fullname, username, email, password)

            database.child(username).setValue(Users).addOnCompleteListener {


                 binding.fullNameSignup.text?.clear()
                 binding.userNameSignup.text?.clear()
                 binding.emailSignup.text?.clear()
                 binding.passwordSignup.text?.clear()
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()


            }.addOnFailureListener {
                Toast.makeText(this, "bumadi", Toast.LENGTH_SHORT).show()

            }
        }

        binding.signInLinkBtn.setOnClickListener {
            startActivity(Intent(this,SiginActivity::class.java))
            finish()
        }

    }




//    private fun CreateAccount() {
//
//        val fullname = binding.fullNameSignup.text.toString()
//        val username = binding.userNameSignup.text.toString()
//        val email = binding.emailSignup.text.toString()
//        val password = binding.passwordSignup.text.toString()
//
//        when{
//
//            TextUtils.isEmpty(fullname)-> Toast.makeText(this, "Iltimos Fullname qatorini to`ldiring", Toast.LENGTH_LONG).show()
//            TextUtils.isEmpty(username)-> Toast.makeText(this, "Iltimos username qatorini to`ldiring", Toast.LENGTH_LONG).show()
//            TextUtils.isEmpty(email)-> Toast.makeText(this, "Iltimos email qatorini to`ldiring", Toast.LENGTH_LONG).show()
//            TextUtils.isEmpty(password)-> Toast.makeText(this, "Iltimos password qatorini to`ldiring", Toast.LENGTH_LONG).show()
//
//               else ->{
//
//                        val progressDialog = ProgressDialog(this@SignupActivity)
//                        progressDialog.setTitle("SIng up")
//                        progressDialog.setMessage("Please wait. It`s loading.... ")
//                        progressDialog.setCanceledOnTouchOutside(false)
//                        progressDialog.show()
//                        val mAuth:FirebaseAuth = FirebaseAuth.getInstance()
//
//
//                        mAuth.createUserWithEmailAndPassword(email, password)
//                                     .addOnCompleteListener { task ->
//                            if (task.isSuccessful){
//                                    saveUserInfo(fullname,username,email,progressDialog)
//                            }
//                               else{
//                                     val message = task.exception!!.toString()
//                                     Toast.makeText(this, "Error:  $message", Toast.LENGTH_LONG).show()
//                                        mAuth.signOut()
//                                      progressDialog.dismiss()
//
//
//                            }
//                        }
//            }
//
//        }
//
//    }
//
//    private fun saveUserInfo(fullname: String, username: String, email: String,progressDialog:ProgressDialog)
//    {
//        val currentUserID = FirebaseAuth.getInstance().currentUser!!.uid
//        val usersRef:DatabaseReference = FirebaseDatabase.getInstance().reference.child("Users")
//        val userMap = HashMap<String,Any>()
//            userMap["uid"] = currentUserID
//            userMap["fullname"] = currentUserID
//            userMap["username"] = currentUserID
//            userMap["bio"] = "Hello, I am Mobile Developer from UZBEKISTAN."
//            userMap["image"] = "https://firebasestorage.googleapis.com/v0/b/instagram-clone-2cfc2.appspot.com/o/man.png?alt=media&token=71acef08-2458-4a9c-9c43-5674ebd3b79a"
//
//            usersRef.child(currentUserID).setValue(userMap)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful){
//                            progressDialog.dismiss()
//                        Toast.makeText(this, "Account has been created successful....", Toast.LENGTH_SHORT).show()
//                      val intent = Intent(this@SignupActivity,MainActivity::class.java)
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//                        startActivity(intent)
//                        finish()
//                    }
//                    else{
//
//                        val message = task.exception!!.toString()
//                        Toast.makeText(this, "Error:  $message", Toast.LENGTH_LONG).show()
//                        FirebaseAuth.getInstance().signOut()
//                        progressDialog.dismiss()
//                    }
//                }
//
//
//
//    }


}