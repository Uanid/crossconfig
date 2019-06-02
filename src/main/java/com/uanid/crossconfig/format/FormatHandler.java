package com.uanid.crossconfig.format;

import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;

public abstract class FormatHandler {

    private DataFormatType dataFormatType;

    public FormatHandler(DataFormatType dataFormatType) {
        this.dataFormatType = dataFormatType;
    }

    //TODO: 예상 flow 시나리오
    //1. rawdata가 내가 원하는 타입인지 검증
    //2. readTree로 JSONNODE로 가져옮
    //3. JSONNODE에서 CONFIGNODE로 변환
    //즉 이 handler는 flow관리자 역할을 하도록 만듦
    public final ConfigNode parse(RawData rawData) throws ParseFailException {
        try {
            if (!isValidRawData(rawData)) {
                throw new ParseFailException("RawData " + rawData.getRawDataType().getDataClass().getCanonicalName() + " is not valid rawData");
            }
            return parseProcess(rawData);
        } catch (Exception e) {
            throw new ParseFailException("Exception caught while parsing a rawData", e);
        }
    }

    public final RawData dump(ConfigNode configNode) throws DumpFailException {
        try {
            return dumpProcess(configNode);
        } catch (Exception e) {
            throw new DumpFailException("Exception caught while dumping a rawData", e);
        }
    }

    protected abstract boolean isValidRawData(RawData rawData);

    protected abstract ConfigNode parseProcess(RawData rawData) throws Exception;

    protected abstract RawData dumpProcess(ConfigNode configNode) throws Exception;

    public DataFormatType getDataFormatType() {
        return dataFormatType;
    }

}
