All-in-one scheduling, payments, and lesson tracking for private tutors.

SCOPE:
- Book lessons
- Take payment
- Reduce admin work

USER ROLES:
1. Tutor (Account Owner)
- Manages availability
- Sets prices
- Gets paid

2. Student / Parent
- Books lessons
- Pays
- Gets reminders


CORE USER FLOWS
Flow 1: Tutor Onboarding (5 minutes)
- Sign up
- Connect Stripe
- Set availability
- Create lesson types
- Share booking link

Flow 2: Student Booking
- Open tutor booking page
- Pick lesson type
- Choose time slot
- Enter name + email
- Pay
- Confirmation email

Flow 3: Tutor Management
- View upcoming lessons
- Mark lesson as completed
- Add private notes
- Cancel / reschedule


FEATURES:

Tutor Dashboard
- Upcoming lessons (list view)
- Earnings this month
- “Share booking link” button
No charts. No reports.

Lesson Types

Each lesson type has:
- Name (e.g. “Math – 60 min”)
- Duration (30 / 60 / 90)
- Price
- Location (Online / In-person)
- Optional description
Limit to max 5 lesson types (keep it simple).

Availability Rules:
- Weekly availability
- Time slots (e.g. Mon 4–8pm)
- Minimum notice (e.g. 12 hours)
- Buffer time between lessons
No vacation logic in MVP (manual block only).

Booking Page (Public): 
URL:yourapp.com/book/{tutorName}
Includes:
- Tutor name + bio
- Lesson types
- Calendar view
- Secure Stripe checkout

Payments (Stripe):
- Payment upfront
- Platform fee (e.g. 5–10%)
- Stripe Connect (Express)
No subscriptions yet.


Email Notifications
Tutor:
- New booking
- Cancellation

Student:
- Booking confirmation
- Reminder (24h before)
Email only. No SMS in MVP.

Lesson Notes (Private):
- Simple text notes
- Only tutor can see
- Stored per lesson



DATA MODEL (HIGH LEVEL)

User:
- id
- email
- password
- role (TUTOR)
TutorProfile:
- user_id
- name
- bio
- timezone
- stripe_account_id
LessonType:
- tutor_id
- name
- duration
- price
AvailabilityRule:
- tutor_id
- day_of_week
- start_time
- end_time
Booking:
- tutor_id
- student_name
- student_email
- lesson_type_id
- start_time
- end_time
- status
- payment_id
LessonNote:
- booking_id
- content



TECH STACK (LOCKED)
Backend;
- Java 21
- Spring Boot
- Spring Security
- JPA (Hibernate)
- PostgreSQL

Frontend:
- Thymeleaf + minimal JS
- TailwindCSS (optional)
Infra:
- Fly.io / Render
- S3-compatible storage (optional)
- SendGrid
- Stripe Connect

🔐 SECURITY (MVP LEVEL)
- Email + password auth
- CSRF protection
- Tutor can only access own data
- No GDPR automation yet

💰 PRICING (FROM DAY 1):
Free:
- 5 bookings/month
Paid:
- $19/month
- Unlimited bookings
- Lower platform fee
Payment handled via Stripe.

⏱️ BUILD PLAN (6 WEEKS)
Week 1
Auth + user model
Tutor profile

Week 2
Availability + lesson types
Booking logic

Week 3
Stripe payments
Webhooks

Week 4
Email notifications
Booking page polish

Week 5
Dashboard
Lesson notes

Week 6
Bug fixes
Landing page
Start charging

🚀 SUCCESS CRITERIA
You succeed if:
10 tutors use it weekly
3 pay within first month
Support emails < 1/day