# Instapay System

This system simulates the [Instapay](https://www.instapay.eg/?lang=ar) system, which can be used for sending money to anyone, anywhere, at any time!

## Description

The Instapay System is designed for users to perform money transfers and pay their bills. The services offered by this system include:

1. Transfer money to another 'Instapay' account.
2. Transfer money to a bank account.
3. Transfer money to a mobile wallet through various mobile wallet providers, including:
   - Telecommunication companies like Vodafone Cash.
   - Banks that provide mobile wallets, such as CIB.
4. Paying utilities' bills, which includes bills for gas, electricity, and water.

## Requirements

### 1) Sign Up

To register with the Instapay System, users can follow these steps:

- Register using a bank account and their registered mobile number at the bank. The phone number is required for verification through the bank's API.

- Register using their mobile number with a wallet provided by a wallet provider. The mobile number must be verified with the wallet provider.

For both types of users, after verifying their bank account or wallet, they need to:

1. Verify their mobile number ownership by receiving an `OTP` and confirming it.
2. Choose a unique username within the system.
3. Set a complex password.

### 2) Sign In

Users can sign in to the system using their Instapay username and password. After logging in, their user profile will be loaded based on their user type.

### 3) User Options

Both types of users have the following options:

1. Transfer money to a wallet using a mobile number.
2. Transfer money to another Instapay account.
3. Inquire about their account balance.
4. Pay bills.

For bank-registered users, an additional option is available:

5. Transfer money to a bank account.

### 4) Utility Bill Payment

This feature involves `creating` and `deducting` utility bills from the user's account. Assumptions about the bill contents should be made to support the creation and payment of three bill types:

1. Gas
2. Electricity
3. Water

