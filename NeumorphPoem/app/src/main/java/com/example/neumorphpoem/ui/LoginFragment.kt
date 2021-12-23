package com.example.neumorphpoem.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.neumorphpoem.R


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var card = view?.findViewById<CardView>(R.id.card)
        var tab = view?.findViewById<TableLayout>(R.id.tablaout)
        var viewpager = view?.findViewById<ViewPager>(R.id.viewpager)

        viewpager?.adapter = PagerAdapter(requireActivity().supportFragmentManager)



        return inflater.inflate(R.layout.fragment_login, container, false)
    }
   class  PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return  2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            var title = ""
            if (position ==0){
                title = "Login"
            }
            if (position ==1){
                title = "Registration"
            }

            return title
        }

        override fun getItem(position: Int): Fragment {

            return  when(position){
                0 ->{
                    viewloginFragment()

                }
                1 ->{
                    RegistrationFragment()

                }

                else ->{
                    RegistrationFragment()
                }
            }

        }

    }




}