package cn.whl.commonutils.service.result;

import cn.whl.commonutils.exception.CommonException;
import cn.whl.commonutils.service.result.strategy.ActionResultStrategy;
import cn.whl.commonutils.service.result.strategy.ActionStrategy;
import cn.whl.commonutils.service.result.strategy.PermissionCheckStrategy;
import cn.whl.commonutils.service.result.strategy.VerificationStrategy;

/**
 * Controller层返回ServiceResult的工具
 *
 * @author wuhailong
 */
public class ServiceResultUtils {

    /**
     * 带返回值的动作
     *
     * @param <T> 返回值泛型
     * @param resultParam 返回参数
     * @param ar 操作的策略实现
     * @return SericeResult
     */
    public static <T> ServiceResult action(ResultParam resultParam, ActionResultStrategy<T> ar) {
        ServiceResult result = new ServiceResult();

        try {
            T actionResult = ar.actionAndGetResult();
            if (actionResult == null) {
                setNull(result);
            } else {
                setSuccess(result);
                setServiceResult(resultParam, result, actionResult);
            }
        } catch (CommonException ex) {
            setCommonException(result, ex);
        } catch (Exception ex) {
            setException(result, ex);
        }
        return result;
    }

    /**
     * 不带返回值的动作
     *
     * @param ar 操作的策略实现
     * @return SericeResult
     */
    public static ServiceResult action(ActionStrategy ar) {
        ServiceResult result = new ServiceResult();

        try {
            ar.action();
            setSuccess(result);
        } catch (CommonException ex) {
            setCommonException(result, ex);
        } catch (Exception ex) {
            setException(result, ex);
        }
        return result;

    }

    /**
     * 带返回值的动作，权限校验
     *
     * @param <T> 返回值泛型
     * @param resultParam 返回参数
     * @param pcs 权限校验的策略实现
     * @param ar 操作的策略实现
     * @return SericeResult
     */
    public static <T> ServiceResult action(ResultParam resultParam, PermissionCheckStrategy pcs, ActionResultStrategy<T> ar) {
        ServiceResult result = new ServiceResult();

        try {
            //校验权限
            Boolean verResult = pcs.verification();

            if (!verResult) {
                //校验未通过
                setNoPower(result);

                return result;
            }

            T actionResult = ar.actionAndGetResult();
            if (actionResult == null) {
                setNull(result);
            } else {
                setSuccess(result);
                setServiceResult(resultParam, result, actionResult);
            }
        } catch (CommonException ex) {
            setCommonException(result, ex);
        } catch (Exception ex) {
            setException(result, ex);
        }
        return result;
    }

    /**
     * 不带返回值的动作，权限校验
     *
     * @param pcs 权限校验的策略实现
     * @param ar 操作的策略实现
     * @return SericeResult
     */
    public static ServiceResult action(PermissionCheckStrategy pcs, ActionStrategy ar) {
        ServiceResult result = new ServiceResult();

        try {
            //校验权限
            Boolean verResult = pcs.verification();

            //校验通过
            if (!verResult) {
                //校验未通过
                setNoPower(result);
                return result;
            }
            
            ar.action();
            setSuccess(result);
        } catch (CommonException ex) {
            setCommonException(result, ex);
        } catch (Exception ex) {
            setException(result, ex);
        }
        return result;

    }

    /**
     * 带返回值的动作，输入校验
     *
     * @param <T> 返回值泛型
     * @param resultParam 返回参数
     * @param vs 校验用户输入的策略实现
     * @param ar 操作的策略实现
     * @return SericeResult
     */
    public static <T> ServiceResult action(ResultParam resultParam, VerificationStrategy vs, ActionResultStrategy<T> ar) {
        ServiceResult result = new ServiceResult();

        //输入校验
        try {
            vs.verification();
            
            T actionResult = ar.actionAndGetResult();
            if (actionResult == null) {
                setNull(result);
            } else {
                setSuccess(result);
                setServiceResult(resultParam, result, actionResult);
            }
        } catch (CommonException ex) {
            setCommonException(result, ex);
        } catch (Exception ex) {
            setException(result, ex);
        }
        return result;
    }

    /**
     * 不带返回值的动作，输入校验
     *
     * @param vs 校验用户输入的策略实现
     * @param ar 操作的策略实现
     * @return SericeResult
     */
    public static ServiceResult action(VerificationStrategy vs, ActionStrategy ar) {
        ServiceResult result = new ServiceResult();

        //输入校验
        try {
            vs.verification();
            
            ar.action();
            setSuccess(result);
        } catch (CommonException ex) {
            setCommonException(result, ex);
        } catch (Exception ex) {
            setException(result, ex);
        }
        return result;
    }

    /**
     * 带返回值的动作，输入校验，权限校验
     *
     * @param <T> 返回值泛型
     * @param resultParam 返回参数
     * @param vs 校验用户输入的策略实现
     * @param pcs 权限校验的策略实现
     * @param ar 操作的策略实现
     * @return SericeResult
     */
    public static <T> ServiceResult action(ResultParam resultParam, VerificationStrategy vs, PermissionCheckStrategy pcs, ActionResultStrategy<T> ar) {
        ServiceResult result = new ServiceResult();

        //输入校验
        try {
            vs.verification();

            //校验权限
            Boolean verResult = pcs.verification();

            if (!verResult) {
                setNoPower(result);

                return result;
            }

            T actionResult = ar.actionAndGetResult();
            if (actionResult == null) {
                setNull(result);
            } else {
                setSuccess(result);
                setServiceResult(resultParam, result, actionResult);
            }
        } catch (CommonException ex) {
            setCommonException(result, ex);
        } catch (Exception ex) {
            setException(result, ex);
        }
        
        return result;
    }

    /**
     * 不带返回值的动作，输入校验，权限校验
     *
     * @param vs 校验用户输入的策略实现
     * @param pcs 权限校验的策略实现
     * @param ar 操作的策略实现
     * @return SericeResult
     */
    public static ServiceResult action(VerificationStrategy vs, PermissionCheckStrategy pcs, ActionStrategy ar) {
        ServiceResult result = new ServiceResult();

        //输入校验
        try {
            vs.verification();

            //校验权限
            Boolean verResult = pcs.verification();

            //校验通过
            if (!verResult) {
                //校验未通过
                setNoPower(result);
                return result;
            }

            ar.action();
            setSuccess(result);
        } catch (CommonException ex) {
            setCommonException(result, ex);
        } catch (Exception ex) {
            setException(result, ex);
        }
        
        return result;
    }
    
    private static void setSuccess(ServiceResult result) {
        result.setSuccess(true);
        result.setMessage("操作成功");
    }

    private static void setNull(ServiceResult result) {
        result.setSuccess(false);
        result.setExceptionCode("<NULL>");
        result.setMessage("运行结果为空");
    }

    private static void setException(ServiceResult result, Exception ex) {
        ex.printStackTrace();
        result.setSuccess(false);
        result.setExceptionCode("COMMONEXP");
        result.setMessage(ex.getMessage());
    }

    private static void setCommonException(ServiceResult result, CommonException ex) {
        ex.printStackTrace();
        result.setSuccess(false);
        result.setExceptionCode(ex.getCODE());
        result.setMessage(ex.exceptionOut());
    }

    private static <T> void setServiceResult(ResultParam resultParam, ServiceResult result, T actionResult) {
        if (ResultParam.Bool.equals(resultParam)) {
            result.setBeTrue((Boolean) actionResult);
        }else if (ResultParam.ResultId.equals(resultParam)) {
            result.setResultId((Long) actionResult);
        }else if (ResultParam.Name.equals(resultParam)) {
            result.setName((String) actionResult);
        }else if (ResultParam.Message.equals(resultParam)) {
            result.setMessage((String) actionResult);
        }else if (ResultParam.IntValue.equals(resultParam)) {
            result.setIntValue((Integer) actionResult);
        }else if (ResultParam.Url.equals(resultParam)) {
            result.setUrl((String) actionResult);
        }else if (ResultParam.Data.equals(resultParam)) {
            result.setData(actionResult);
        }
    }

    
    private static void setNoPower(ServiceResult result) {
        //权限校验未通过
        result.setSuccess(false);
        result.setExceptionCode("<NOPOWER>");
        result.setMessage("不具备权限进行此操作");
    }
}
