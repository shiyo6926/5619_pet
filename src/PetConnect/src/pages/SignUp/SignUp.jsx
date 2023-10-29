import React, { Component, useState } from 'react';
import { Link } from 'react-router-dom';
import { Box, Button, CssBaseline, FormLabel, TextField, Typography } from '@mui/material';
import { Stack } from '@mui/material';
import { useFormik } from 'formik';
import { useHistory } from 'react-router-dom'
import * as Yup from 'yup';
import ShowPasswordButton from './ShowPasswordButton';
import { FormInputWrapper } from '../../components/FormInputWrapper';
import axios from 'axios';
import { message } from 'antd';


const SignUp = () => {
  const [passwordVisible, setPasswordVisible] = useState(false)
  const [confirmPasswordVisible, setConfirmPasswordVisible] = useState(false)
  const history = useHistory()

  const instance = axios.create({
    baseURL: 'http://localhost:9090', // 后端的地址
  });

  const formik = useFormik({
    initialValues: {
      userID:'',
      userName: '',
      email: '',
      pet: '',
      password: '',
      userType: 'individual',
    },
    //给后端的
    //onSubmit: values => { console.log(values) },
    onSubmit: async values => {
      console.log('values: ', values)
      try {
        const response = await instance.post('/sign_up', values);
        if (response.data.reason === 'success') {
          message.success('Registered successfully')
          history.push('/SignIn')
        } 
        else {
          message.error(response.data.reason)
          console.log(response.data.reason)
        }
      } catch (error) {
        console.error('请求失败', error)
      }
    },
    validationSchema: Yup.object().shape({
      userName: Yup.string().trim().required('Name is required'),
      email: Yup.string().trim().required('Email is required').email('Email is invalid'),
      pet: Yup.string().trim(),
      password: Yup.string()
        .trim()
        .required('Password is required')
        .min(8, 'Password must have at least 8 characters')
        .matches(/^(?=.*[a-z])/, 'Password must have at least one lowercase')
        .matches(/^(?=.*[A-Z])/, 'Password must have at least one uppercase')
        .matches(/^(?=.*[0-9])/, 'Password must have at least one number')
        .matches(
          /^.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?].*$/,
          'Password must have at least one special character'
        ),
      confirmPassword: Yup.string()
        .required('Confirm Password is required')
        .trim()
        .min(8, 'Password must have at least 8 characters')
        .oneOf([Yup.ref('password'), null], 'Passwords must match'),
    }),
  })


  const commonProps = key => {
    const { errors, values, touched, handleChange, handleBlur } = formik
    return {
      fullWidth: true,
      size: 'small',
      name: key,
      onBlur: handleBlur,
      onChange: handleChange,
      value: values[key],
      error: touched[key] && errors[key],
      helperText: touched[key] && errors[key],
    }
  }
  return (
    <div className="row">
      <Box
        sx={{
          display: {
            xs: 'none', // 在小屏幕上隐藏
            md: 'block', // 在中等及以上屏幕显示
          }
        }}
      >
        <div
          className='col-md-5'
          style={{ backgroundColor: '#FFA1E5', height: '100vh' }}>
          <img
            src="/pic3.png"
            alt="Description of the image"
            style={{
              width: '100%',
              display: 'block',
            }}
          ></img>
        </div>
      </Box>
      <div className='col-md-1'></div>
      <div className='col-md-5'>
        <FormInputWrapper
          component="form"
          onSubmit={formik.handleSubmit}
          style={{ width: '90%' }}>
                        <Typography variant="h2" fontWeight="bold" marginTop={5}>
                            Sign Up
                        </Typography>
          <h3>Embark on a New Chapter in Pet Care</h3>
          <br />

          <FormLabel style={{ fontSize: '14px' }}>Name*</FormLabel>
          <Stack
            direction="row"
            justifyContent="space-between"
            sx={{ width: { sm: '70%', md: '100%', lg: '70%' } }}>
            <TextField placeholder="Your Name" {...commonProps('userName')} />
          </Stack>
          <br />

          <FormLabel style={{ fontSize: '14px' }}>Email*</FormLabel>
          <Stack
            direction="row"
            justifyContent="space-between"
            sx={{ width: { sm: '70%', md: '100%', lg: '70%' } }}>
            <TextField placeholder="Email" {...commonProps('email')} />
          </Stack>
          <br />

          <FormLabel style={{ fontSize: '14px' }}>Pet</FormLabel>
          <Stack
            direction="row"
            justifyContent="space-between"
            sx={{ width: { sm: '70%', md: '100%', lg: '70%' } }}>
            <TextField placeholder="Cat/Dog/Other" {...commonProps('pet')} />
          </Stack>
          <br />

          <FormLabel style={{ fontSize: '14px' }}>Password*</FormLabel>
          <Stack>
            <TextField
              sx={{ width: { sm: '70%', md: '100%', lg: '70%' } }}
              type={passwordVisible ? 'text' : 'password'}
              placeholder="Password"
              InputProps={{
                endAdornment: (
                  <ShowPasswordButton
                    onClick={() => {
                      setPasswordVisible(!passwordVisible)
                    }}
                    visibility={passwordVisible}
                  />
                ),
              }}
              {...commonProps('password')}
            />
          </Stack>
          <br />

          <FormLabel style={{ fontSize: '14px' }}>Confirm Password*</FormLabel>
          <Stack>
            <TextField
              sx={{ width: { sm: '70%', md: '100%', lg: '70%' } }}
              type={confirmPasswordVisible ? 'text' : 'password'}
              placeholder="Confirm Password"
              value={formik.values.confirmPassword}
              {...commonProps('confirmPassword')}
              InputProps={{
                endAdornment: (
                  <ShowPasswordButton
                    onClick={() => {
                      setConfirmPasswordVisible(!confirmPasswordVisible)
                    }}
                    visibility={confirmPasswordVisible}
                  />
                ),
              }}
            />
          </Stack>

          <Stack direction="row" justifyContent="center" marginTop={4}>
            <Button
              variant="contained"
              type="submit"
              style={{
                backgroundColor: '#FFA1E5',
                color: '#FFF',
                fontSize: 14,
                width: 150,
                height: 50,
                borderRadius: 30,
              }}>
              Sign Up
            </Button>
          </Stack>

          <br />
          <h5>Already have an account?</h5>
          <Link to="/SignIn">
            Sign In
          </Link>
        </FormInputWrapper>
      </div>
    </div>
  );
}

export default SignUp;