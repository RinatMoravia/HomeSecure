package entities

case class MergedCsvFile(fileLine: FileLine, deviceInfoDto: DeviceInfoDto) extends Csv {

  override def getFileLine: List[String] = fileLine.getFileLine ++ deviceInfoDto.getFileLine
}

object MergedCsvFile{

  def apply(fileLine: FileLine, deviceInfoDto: DeviceInfoDto): MergedCsvFile = new MergedCsvFile(fileLine, deviceInfoDto)
  val csvSchema: List[String] = FileLine.csvSchema ++ DeviceInfoDto.csvSchema

}
