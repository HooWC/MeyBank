<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../assets/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/faqs.css" />
</head>
<body>


  <section id="infinite2" class="text-white tm-font-big tm-parallax">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-md tm-navbar2" id="tmNav">
      <div class="container">
        <div class="tm-next">
          <a href="home.jsp" class="navbar-brand"><img src="../../image/meybank-logo.png" width="30px">Meybank</a>
        </div>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <i class="fas fa-bars navbar-toggler-icon"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link tm-nav-link" href="home.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link tm-nav-link" href="whatwedo.jsp">What We Do</a>
            </li>
            <li class="nav-item">
              <a class="nav-link tm-nav-link" href="policy.jsp">Policy</a>
            </li>
            <li class="nav-item" style="background-color: rgb(153, 51, 80);border-radius: 5px;color: #FFF;">
              <a class="nav-link tm-nav-link" href="faqs.jsp">FAQ's</a>
            </li>
            <li class="nav-item">
              <a class="nav-link tm-nav-link" href="contact.jsp">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </section>


    <div class="container-FAQ">
        <h2>Frequently Asked Questions</h2>
        <div class="accordion">
          <div class="accordion-item">
            <button id="accordion-button-1" aria-expanded="false"><span class="accordion-title">What can I do under "Profile Maintenance"?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>(A) Change of Address Request (sent to Account Holding branch)</p>
              <p>(B) Change Password</p>
              <p>(C) Change Personal Details</p>
              <p>(D) Change of Third Party Transfer Limit / FPX Transfer Limit</p>
              <p>(E) PBe Alert / Notification</p>
              <p>(F) Change Credit/Debit Card info</p>
              <p>(G) Change Personal Login Phrase</p>
              <p>(H) Unregister PAC</p>
              <p>(I) Add / Delete Account</p>
              <p>(J) Challenge Questions Enrolment</p>
              <p>(K) Change Challenge Questions</p>
              <p>(L) Cancel ATM Card</p>
              <p>(M) Manage Card Profile</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-2" aria-expanded="false"><span class="accordion-title">Can I deposit cheque to my MeyBank Sharelink account to settle purchase contracts?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>Yes. However, it is subject to a maximum amount of RM 200,000.00.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-3" aria-expanded="false"><span class="accordion-title">How safe are transactions performed on MeyBank?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>MeyBank utilises a Transport Layer Security (TLS) encryption. The encryption ensures your User ID, password and banking transactions remain confidential. </p>
              <p>Rest assured, every transaction is fully secured.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">I have exceeded the number of login attempts.</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>You are only allowed 3 login attempts. If you have exceeded the number of attempts allowed, please contact our PBe Customer Support at 03-2179 9999 for assistance.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-5" aria-expanded="false"><span class="accordion-title">Do I need to enable cookies in my browser when using MeyBank?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>Generally, we recommend customers to enable first-party cookies. First-party cookies are files created by the site you visit (in this case pbebank.com) which will save your browsing data. </p>
              <p>Please refer to your respective browser developer for guidance on enabling cookies.</p>
                
              <p>Enabling cookies on an iPad and iPhone</p>
              <ol style="list-style-type: upper-roman;">
                <li>Tap on “Settings”</li>
                <li>Scroll down and select “Safari”</li>
                <li>Turn OFF “Block All Cookies” option.</li>
                <li>Restart your iPad / iPhone</li>
              </ol>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">What is “To Own Account”?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>“To Own Account” means transferring funds to your personal accounts which are linked to your PBe profile.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">What is E-Statement?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>Current Account holders may download a PDF statement of their monthly balance and transactions by clicking on E-statement. The file can be viewed using Adobe PDF reader, obtainable at
                <a href="http://www.adobe.com/products/acrobat/readstep.html">http://www.adobe.com/products/acrobat/readstep.html</a></p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">How do I perform Bill Payments?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>Please follow the steps listed below:</p>
              <ol style="list-style-type: upper-roman;">
                <li>Click Payment</li>
                <li> Click Bill Payment</li>
                <li>Click To Other Bill</li>
                <li>Select one of the Payee Corporations from the drop-down list</li>
                <li>Key-in the necessary information and confirm your payment</li>
              </ol>
              <p>* Take Note: Please omit spaces and dashes for the Bill Account Reference (which is Bill Account Number) input field.</p>
              <p>After a successful bill payment, you will notice a "Store Registration" button on your computer screen. This feature allows you to record information of your bill payee corporation. Once that is done, you can enjoy the To Favourite Bill feature on your next bill payment.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">What can I do under the “Cheque Book Request” feature?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>You can request new cheque books for your Current Account. You are able to order a maximum of 10 cheque books per request.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">What is Digital Signing?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>Digital Signing is a process whereby a transaction performed through PBe is approved by the authorizer(s) based on a SecureSign Code generated by the SecureSign token. The SecureSign Code generated is unique to that particular token issued to the authorizer and the PIN activated.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">Can companies use PBe online banking?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>MeyBank is designed for retail customers, sole proprietors and corporate customers. Corporate customers usually consist of companies such as Sdn Bhd, Bhd and Partnerships.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">How do I link my accounts to my PBe profile?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>You are allowed to add multiple accounts in your PBe profile, provided they are opened at the same branch.  Kindly visit your account holding branch to link your accounts to your PBe profile. </p>
              <p>Accounts eligible to be linked include:</p>
              <ol style="list-style-type: upper-roman;">
                <li>Savings / Current Account</li>
                    <li>Fixed Deposit Account</li>
                    <li>Gold Investment Account</li>
                    <li>Foreign Currency Account</li>
                    <li>Share Link Account</li>
                    <li>Loans Account</li>
                    <li>Hire Purchase Account</li>
                    <li>Credit / Debit Card</li>
                    <li>Retail Negotiable Instrument of Deposit / Retail Negotiable Islamic Debt Certificate</li>
              </ol>
              <p>* Take Note: for Joint Account holders, your mode of signing must be either one to sign. When registering for a PBe profile, both signatories must provide identification and sign on our E-banking Modification form.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">What is FPX?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>FPX is an internet based payment gateway that allows real-time payments for online purchases or bill payments. FPX is operated by Payments Network Malaysia Sdn Bhd (PayNet).</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">How do I download and print GST Tax Invoice?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
                <ol style="list-style-type: upper-roman;">
                    <li>Login to PBe and click ACCOUNT at the Welcome Page.</li>
                        <li>Click Print GST Tax Invoice.</li>
                        <li>Select Account No, Year, Month and then click Next.</li>
                        <li>Click on Tax Invoice Number.</li>
                        <li>The selected Tax Invoice will be displayed. You may save and print the Tax Invoice.</li>
                </ol>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">What is E-SI?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>E-Standing Instruction is a convenient service that makes automated payments of a fixed amount to a loan, bill, or credit card at a pre-set time and date. You can schedule a one off payment or repeated payments with E-SI.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">What is DuitNow service?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>DuitNow is a fund transfer service where you can transfer funds instantly on a 24/7 basis via Recipient ID called DuitNow ID. With DuitNow, you will enjoy a simple and convenient way to transfer money. </p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">What is MeyBank engage?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>MeyBank engage enables you to perform online banking transactions on your iOS or Android mobile devices.</p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">What is MeyBank enterprise?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>MeyBank enterprise is Public Bank's new corporate online banking platform. It offeres a range of enhanced functions and features designed to support your business needs. </p>
            </div>
          </div>
          <div class="accordion-item">
            <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">What is Reset Password / Reactivate User ID?</span><span class="icon" aria-hidden="true"></span></button>
            <div class="accordion-content">
              <p>This service enables existing PBe Users who have forgotten their PBe Password to reset their password and/or reactivate their User ID which was deactivated due to incorrect password.</p>
            </div>
          </div>
        </div>
      </div>
    
      <script src="../script/faqs.js"></script>

</body>
</html>