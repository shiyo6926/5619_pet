import { Link } from 'react-router-dom';
import {
    Box,
    Button,
    CssBaseline,
    FormLabel,
    IconButton,
    InputAdornment,
    Dialog,
    DialogContent,
    TextField,
    Tooltip,
    Typography,
} from '@mui/material';
import * as Yup from 'yup';
import { Stack } from '@mui/material';
import { InfoRounded, Visibility, VisibilityOff } from '@mui/icons-material';
import React, { useState, useEffect  } from 'react';
import { useHistory } from 'react-router-dom';
import { useFormik } from 'formik';
import { FormInputWrapper } from '../../components/FormInputWrapper';
import ShowPasswordButton from '../SignUp/ShowPasswordButton';
import axios from 'axios';
import { message } from 'antd';
import { Vertify } from '@alex_xu/react-slider-vertify'

const PasswordStrengthTooltip = () => {
    return (
        <Box>
            <ul>
                <li>Minimum of 8 characters</li>
                <li>Contain an uppercase</li>
                <li>Contain a lowercase</li>
                <li>Contain a number (0-9)</li>
                <li>Contain a special character (!@#$%^&*)</li>
            </ul>
        </Box>
    )
}

const PasswordTooltip = ({ isError }) => {
    return (
        <Tooltip
            title={<PasswordStrengthTooltip />}
            sx={{
                marginBottom: {
                    lg: isError ? '24px' : 0,
                },
            }}>
            <IconButton>
                <InfoRounded fontSize="small" sx={{ color: '#FFA1E5', fontSize: '1.3rem' }} />
            </IconButton>
        </Tooltip>
    )
}

const SignIn = ({ redirectPath }) => {

    // State to Manage password visibility
    const [passwordVisible, setPasswordVisible] = useState(false)
    // State for tracking loading request
    const [loading, setLoading] = useState(false)
    const [open, setOpen] = useState(false)

    const history = useHistory()

    const instance = axios.create({
        baseURL: 'http://localhost:9090', // 后端的地址
    });

    //这个别取消注释，取消了就一直0了localStorage.setItem('userId', '');

    const formik = useFormik({
        initialValues: { userName: '', password: '' },
        //onSubmit: values => { console.log(values) },
        onSubmit: async values => {
            try {
                const response = await instance.post('/sign_in', values);
                if (response.data.reason === 'success') {
                    // localStorage.setItem('isAuthenticated', 'true');
                    console.log('登录页面的isAuthenticated', response.data.reason)
                    localStorage.setItem('userId', response.data.userId);
                    localStorage.setItem('userName', response.data.userName);
                    const storedUserId = localStorage.getItem('userId');
                    console.log('userId:', storedUserId)
                    history.push('/home')
                    window.location.reload();
                    message.success('login successfully')
                    history.push('/home')
                } else {
                    message.error('login failure')
                    console.log('login failure')
                }
            } catch (error) {
                console.error('request failed', error)
            }
        },

        validationSchema: Yup.object({
            userName: Yup.string().required('User Name or Email can not be empty'),
            password: Yup.string().required('Password can not be empty'),
        }),
    })


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
                <FormInputWrapper onSubmit={formik.handleSubmit} component="form" target="none">
                    <Typography variant="h2" fontWeight="bold" marginTop={5}>
                        Sign In
                    </Typography>
                    <Typography variant="h5" marginTop={3}>
                        Welcome to PetConnect, please enter your login credentials below to start
                        using the app.
                    </Typography>

                    <FormInputWrapper marginTop={5}>
                        <FormLabel style={{ fontSize: '15px', display: 'block', width: 200 }}>User Name/Email*</FormLabel>
                        <TextField
                            type="text"
                            variant="outlined"
                            fullWidth
                            size="small"
                            placeholder="Your User Name or Email "
                            name="userName"
                            value={formik.values.userName}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.userName && formik.errors.userName}
                            helperText={formik.touched.userName && formik.errors.userName}
                        />
                    </FormInputWrapper>

                    <FormInputWrapper marginTop={2}>
                        <div style={{ display: 'block', width: 200 }}>
                            <FormLabel style={{ fontSize: '15px' }}>Password*</FormLabel>
                            <PasswordTooltip />
                        </div>

                        <TextField
                            size="small"
                            type={passwordVisible ? 'text' : 'password'}
                            variant="outlined"
                            placeholder="Your Password"
                            fullWidth
                            name="password"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.password && formik.errors.password}
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
                            autoComplete="new-password"
                        // error={errors.password ? true : false}
                        // helperText={errors.password?.message}
                        />
                    </FormInputWrapper>
                    <Stack direction="row" justifyContent="center" marginTop={4}>
                        <Button
                            variant="contained"
                            //type="submit"
                            onClick={() => {
                                if (formik.isValid) {
                                    setOpen(true)
                                    return
                                }
                                formik.handleSubmit()
                            }}
                            style={{
                                backgroundColor: '#FFA1E5',
                                fontSize: 14,
                                color: '#FFF',
                                width: 150,
                                height: 50,
                                borderRadius: 30,
                            }}
                            disabled={loading}>
                            Sign In
                        </Button>

                    </Stack>
                    <br />
                    <h5>Don't have an account?</h5>
                    <Link to="/SignUp">
                        Sign Up
                    </Link>
                </FormInputWrapper>

                <Dialog onClose={() => setOpen(false)} open={open}>
                    <DialogContent dividers>
                        <Vertify
                            width={320}
                            height={160}
                            visible={true}
                            onSuccess={() => {
                                formik.handleSubmit()
                            }} //成功触发事件
                            onFail={() => {
                                console.log('onFail')
                            }} // 失败触发事件
                            onRefresh={() => alert('refresh')}
                        />
                    </DialogContent>
                </Dialog>
            </div>
        </div>
    );

}

export default SignIn;