package com.example.network.model


import androidx.versionedparcelable.ParcelField
import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class NetworkModel(
    val access_token: String,
    val doctor_details: User,
    val message: String,
    val success: Boolean
)

data class User(
    val about: String?,
    val care_type: String?,
    val createdAt: String?,
    val dob: String?,
    val profile_pic:String?,
    val email: String?,
    val firstname: String?,
    val gender: String?,
    val _id: String?,
    val lastname: String?,
    val password: String?,
    val phone: Long?,
    val profilePic: String?,
    val speciality: String?,
    val updatedAt: String?,
    val v: Int?,
    val register_id: String?

)

data class FcmToken(
    val apnToken: String,
    val deviceToken: String,
    val deviceType: String
)

data class ResetResponse(
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("newpassword")
    val newpassword: String?,
    @SerializedName("oldpassword")
    val confirmpassword: String?
)

data class OtpResponse(
    @SerializedName("message")
    val message: String?,
    @SerializedName("otp")
    val otp: String?,
    @SerializedName("success")
    val success: Boolean?
)

data class AppoimentResponse(
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("upcoming_appointmnets")
    val upcomingAppointmnets: List<UpcomingAppointmnet?>?
)




@Parcelize
data class UpcomingAppointmnet(
    @SerializedName("appointment_type")
    val appointmentType: String?,
    @SerializedName("booked_by_insurance_or_membership")
    val bookedByInsuranceOrMembership: String?,
    @SerializedName("booking_date")
    val bookingDate: String?,
    @SerializedName("care_type")
    val careType: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("doctor_id")
    val doctorId: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("is_appointment_for_family")
    val isAppointmentForFamily: Boolean?,
    @SerializedName("is_cancelled")
    val isCancelled: Boolean?,
    @SerializedName("is_completed")
    val isCompleted: Boolean?,
    @SerializedName("patient_id")
    val patientId: PatientId?,
    @SerializedName("payment_amount")
    val paymentAmount: Int?,
    @SerializedName("purchased_plan_id")
    val purchasedPlanId: String?,
    @SerializedName("reason_to_visit")
    var reasonToVisit: String?,
    @SerializedName("slot_id")
    val slotId: SlotId?,
    @SerializedName("transaction_id")
    val transactionId: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("__v")
    val v: Int?
) : Parcelable {

    @Parcelize
    data class PatientId(
        @SerializedName("createdAt")
        val createdAt: String?,
        @SerializedName("dob")
        val dob: String?,
        @SerializedName("email")
        val email: String?,
        @SerializedName("firstname")
        val firstname: String?,
        @SerializedName("gender")
        val gender: String?,
        @SerializedName("_id")
        val id: String?,
        @SerializedName("isInsuranceInfoCompleted")
        val isInsuranceInfoCompleted: Boolean?,
        @SerializedName("lastname")
        val lastname: String?,
        @SerializedName("phone")
        val phone: Long?,
        @SerializedName("updatedAt")
        val updatedAt: String?,
        @SerializedName("__v")
        val v: Int?
    ) : Parcelable

    @Parcelize
    data class SlotId(
        @SerializedName("care_type")
        val careType: String?,
        @SerializedName("createdAt")
        val createdAt: String?,
        @SerializedName("day")
        val day: String?,
        @SerializedName("doctor_id")
        val doctorId: String?,
        @SerializedName("end_time")
        val endTime: String?,
        @SerializedName("_id")
        val id: String?,
        @SerializedName("slot_status")
        val slotStatus: Boolean?,
        @SerializedName("start_time")
        val startTime: String?,
        @SerializedName("updatedAt")
        val updatedAt: String?,
        @SerializedName("__v")
        val v: Int?,
        @SerializedName("visit_type")
        val visitType: String?
    ) : Parcelable
}

//data class UpcomingAppointmnet(
//    @SerializedName("appointment_type")
//    val appointmentType: String?,
//    @SerializedName("booked_by_insurance_or_membership")
//    val bookedByInsuranceOrMembership: String?,
//    @SerializedName("booking_date")
//    val bookingDate: String?,
//    @SerializedName("care_type")
//    val careType: String?,
//    @SerializedName("createdAt")
//    val createdAt: String?,
//    @SerializedName("doctor_id")
//    val doctorId: String?,
//    @SerializedName("_id")
//    val id: String?,
//    @SerializedName("is_appointment_for_family")
//    val isAppointmentForFamily: Boolean?,
//    @SerializedName("is_cancelled")
//    val isCancelled: Boolean?,
//    @SerializedName("is_completed")
//    val isCompleted: Boolean?,
//    @SerializedName("patient_id")
//    val patientId: PatientId?,
//    @SerializedName("payment_amount")
//    val paymentAmount: Int?,
//    @SerializedName("purchased_plan_id")
//    val purchasedPlanId: String?,
//    @SerializedName("reason_to_visit")
//    var reasonToVisit: String?,
//    @SerializedName("slot_id")
//    val slotId: SlotId?,
//    @SerializedName("transaction_id")
//    val transactionId: String?,
//    @SerializedName("updatedAt")
//    val updatedAt: String?,
//    @SerializedName("__v")
//    val v: Int?
//) {
//    data class PatientId(
//        @SerializedName("createdAt")
//        val createdAt: String?,
//        @SerializedName("dob")
//        val dob: String?,
//        @SerializedName("email")
//        val email: String?,
//        @SerializedName("firstname")
//        val firstname: String?,
//        @SerializedName("gender")
//        val gender: String?,
//        @SerializedName("_id")
//        val id: String?,
//        @SerializedName("isInsuranceInfoCompleted")
//        val isInsuranceInfoCompleted: Boolean?,
//        @SerializedName("lastname")
//        val lastname: String?,
//        @SerializedName("phone")
//        val phone: Long?,
//        @SerializedName("updatedAt")
//        val updatedAt: String?,
//        @SerializedName("__v")
//        val v: Int?
//    )
//
//    data class SlotId(
//        @SerializedName("care_type")
//        val careType: String?,
//        @SerializedName("createdAt")
//        val createdAt: String?,
//        @SerializedName("day")
//        val day: String?,
//        @SerializedName("doctor_id")
//        val doctorId: String?,
//        @SerializedName("end_time")
//        val endTime: String?,
//        @SerializedName("_id")
//        val id: String?,
//        @SerializedName("slot_status")
//        val slotStatus: Boolean?,
//        @SerializedName("start_time")
//        val startTime: String?,
//        @SerializedName("updatedAt")
//        val updatedAt: String?,
//        @SerializedName("__v")
//        val v: Int?,
//        @SerializedName("visit_type")
//        val visitType: String?
//    )
//}




data class CompleteResponse(
    @SerializedName("completed_appointmnets")
    val completedAppointmnets: List<CompletedAppointmnet?>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?
) {
    data class CompletedAppointmnet(
        @SerializedName("appointment_type")
        val appointmentType: String?,
        @SerializedName("booked_by_insurance_or_membership")
        val bookedByInsuranceOrMembership: String?,
        @SerializedName("booking_date")
        val bookingDate: String?,
        @SerializedName("care_type")
        val careType: String?,
        @SerializedName("createdAt")
        val createdAt: String?,
        @SerializedName("doctor_id")
        val doctorId: String?,
        @SerializedName("_id")
        val id: String?,
        @SerializedName("is_appointment_for_family")
        val isAppointmentForFamily: Boolean?,
        @SerializedName("is_cancelled")
        val isCancelled: Boolean?,
        @SerializedName("is_completed")
        val isCompleted: Boolean?,
        @SerializedName("patient_id")
        val patientId: PatientId?,
        @SerializedName("payment_amount")
        val paymentAmount: Int?,
        @SerializedName("purchased_plan_id")
        val purchasedPlanId: String?,
        @SerializedName("reason_to_visit")
        var reasonToVisit: String?,
        @SerializedName("slot_id")
        val slotId: SlotId?,
        @SerializedName("transaction_id")
        val transactionId: String?,
        @SerializedName("updatedAt")
        val updatedAt: String?,
        @SerializedName("__v")
        val v: Int?
    ) {
        data class PatientId(
            @SerializedName("createdAt")
            val createdAt: String?,
            @SerializedName("dob")
            val dob: String?,
            @SerializedName("email")
            val email: String?,
            @SerializedName("firstname")
            val firstname: String?,
            @SerializedName("gender")
            val gender: String?,
            @SerializedName("_id")
            val id: String?,
            @SerializedName("isInsuranceInfoCompleted")
            val isInsuranceInfoCompleted: Boolean?,
            @SerializedName("lastname")
            val lastname: String?,
            @SerializedName("phone")
            val phone: Long?,
            val profile_pic : String?,
            @SerializedName("updatedAt")
            val updatedAt: String?
        )

        data class SlotId(
            @SerializedName("care_type")
            val careType: String?,
            @SerializedName("createdAt")
            val createdAt: String?,
            @SerializedName("day")
            val day: String?,
            @SerializedName("doctor_id")
            val doctorId: String?,
            @SerializedName("end_time")
            val endTime: String?,
            @SerializedName("_id")
            val id: String?,
            @SerializedName("slot_status")
            val slotStatus: Boolean?,
            @SerializedName("start_time")
            val startTime: String?,
            @SerializedName("updatedAt")
            val updatedAt: String?,
            @SerializedName("__v")
            val v: Int?,
            @SerializedName("visit_type")
            val visitType: String?
        )
    }

}
